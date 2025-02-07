package com.example.cursos.service;

import com.example.cursos.dto.CourseRequestDTO;
import com.example.cursos.dto.CourseResponseDTO;
import com.example.cursos.exception.ResourceNotFoundException;
import com.example.cursos.model.Course;
import com.example.cursos.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final CourseRepository courseRepository;

    @Override
    public void save(CourseRequestDTO request) {
        courseRepository.save(Course.builder()
                .name(request.getName())
                .type(request.getType())
                .endDate(request.getEndDate())
                .build()
        );
    }

    @Override
    public List<CourseResponseDTO> findAll() {
        return courseRepository.findAll().stream()
                .map(course -> CourseResponseDTO.builder()
                        .name(course.getName())
                        .type(course.getType())
                        .endDate(course.getEndDate())
                        .build()
                ).toList();
    }

    @Override
    public List<CourseResponseDTO> findByName(String name) {
        return courseRepository.findByNameContainingIgnoreCase(name).stream()
                .map(course -> CourseResponseDTO.builder()
                        .name(course.getName())
                        .type(course.getType())
                        .endDate(course.getEndDate())
                        .build()
                ).toList();
    }

    @Override
    public CourseResponseDTO update(Long id, CourseRequestDTO request) {
        Course course = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id));

        course.setName(request.getName());
        course.setType(request.getType());
        course.setEndDate(request.getEndDate());

        courseRepository.save(course);

        return CourseResponseDTO.builder()
                .name(course.getName())
                .type(course.getType())
                .endDate(course.getEndDate())
                .build();
    }

    @Override
    public void delete(Long id) {
        courseRepository.delete(courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + id)));
    }
}
