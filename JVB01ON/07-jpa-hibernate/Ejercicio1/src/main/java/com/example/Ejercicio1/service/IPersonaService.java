package com.example.Ejercicio1.service;

import com.example.Ejercicio1.dto.PersonaRequestDTO;
import com.example.Ejercicio1.dto.PersonaResponseDTO;

import java.util.List;

public interface IPersonaService {
    public List<PersonaResponseDTO> findAll();
    public void save(PersonaRequestDTO request);
    public void delete(Long id);
    public PersonaResponseDTO update(Long id, PersonaRequestDTO request);
}
