package com.example.Ejercicio2.service;

import com.example.Ejercicio2.dto.PatientDTO;
import com.example.Ejercicio2.model.Patient;

import java.util.List;

public interface IPatientService {
    public void save(Patient patient);
    public List<PatientDTO> findAll();
    public boolean delete(Long id);
    public PatientDTO findById(Long id);
    public PatientDTO edit(Long id, String name, String surname, int age);
}
