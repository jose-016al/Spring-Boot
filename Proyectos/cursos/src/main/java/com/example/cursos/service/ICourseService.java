package com.example.cursos.service;

import com.example.cursos.dto.CourseRequestDTO;
import com.example.cursos.dto.CourseResponseDTO;

import java.util.List;

public interface ICourseService {
    public void save(CourseRequestDTO request);
    public List<CourseResponseDTO> findAll();
    public List<CourseResponseDTO> findByName(String name);
    public CourseResponseDTO update(Long id, CourseRequestDTO request);
    public void delete(Long id);
}
