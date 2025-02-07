package com.example.cursos.service;

import com.example.cursos.dto.SubjectRequestDTO;
import com.example.cursos.dto.SubjectResponseDTO;

import java.util.List;

public interface ISubjectService {
    public void save(SubjectRequestDTO request);
    public List<SubjectResponseDTO> findByCourse(Long id);
    public SubjectResponseDTO update(Long id, SubjectRequestDTO request);
    public void delete(Long id);
}
