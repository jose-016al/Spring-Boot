package com.example.clinca_odontologica.service;

import com.example.clinca_odontologica.dto.DentistRequestDTO;
import com.example.clinca_odontologica.dto.DentistResponseDTO;
import com.example.clinca_odontologica.model.Dentist;

import java.util.List;

public interface IDentistService {
    public DentistResponseDTO save(DentistRequestDTO request);
    public List<DentistResponseDTO> findAll();
    public Dentist findById(Long id);
    public DentistResponseDTO update(Long id, DentistRequestDTO request);
    public void delete(Long id);
}
