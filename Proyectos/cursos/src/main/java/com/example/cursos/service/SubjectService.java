package com.example.cursos.service;

import com.example.cursos.dto.CourseResponseDTO;
import com.example.cursos.dto.SubjectRequestDTO;
import com.example.cursos.dto.SubjectResponseDTO;
import com.example.cursos.exception.ResourceNotFoundException;
import com.example.cursos.model.Course;
import com.example.cursos.model.Subject;
import com.example.cursos.repository.CourseRepository;
import com.example.cursos.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService implements ISubjectService {

    private final SubjectRepository subjectRepository;
    private final CourseRepository courseRepository;

    @Override
    public void save(SubjectRequestDTO request) {
        subjectRepository.save(Subject.builder()
                .name(request.getName())
                .description(request.getDescription())
                .course(courseRepository.findById(request.getCourseId())
                        .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + request.getCourseId())))
                .build()
        );
    }

    @Override
    public List<SubjectResponseDTO> findByCourse(Long id) {
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Curso no encontrado con ID: " + id);
        }

        return subjectRepository.findByCourseId(id).stream()
                .map(subject -> SubjectResponseDTO.builder()
                        .name(subject.getName())
                        .description(subject.getDescription())
                        .build()
                ).toList();
    }

    @Override
    public SubjectResponseDTO update(Long id, SubjectRequestDTO request) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tema no encontrado con ID: " + id));

        Course course = courseRepository.findById(request.getCourseId())
                .orElseThrow(() -> new ResourceNotFoundException("Curso no encontrado con ID: " + request.getCourseId()));

        subject.setName(request.getName());
        subject.setDescription(request.getDescription());
        subject.setCourse(course);

        subjectRepository.save(subject);

        return SubjectResponseDTO.builder()
                .name(subject.getName())
                .description(subject.getDescription())
                .build();

    }

    @Override
    public void delete(Long id) {
        subjectRepository.delete(subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tema no encontrado con ID: " + id)));
    }
}
