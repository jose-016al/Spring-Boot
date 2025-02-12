package com.example.clinca_odontologica.service;

import com.example.clinca_odontologica.dto.PatientRequestDTO;
import com.example.clinca_odontologica.dto.PatientResponseDTO;
import com.example.clinca_odontologica.model.Patient;

import java.util.List;

public interface IPatientService {
    public PatientResponseDTO save(PatientRequestDTO request);
    public List<PatientResponseDTO> findAll();
    public Patient findById(Long id);
    public PatientResponseDTO update(Long id, PatientRequestDTO request);
    public void delete(Long id);
}
