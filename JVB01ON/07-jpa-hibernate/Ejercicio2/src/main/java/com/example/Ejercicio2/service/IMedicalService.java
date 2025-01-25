package com.example.Ejercicio2.service;



import com.example.Ejercicio2.dto.MedicalDTO;
import com.example.Ejercicio2.model.Medical;

import java.util.List;

public interface IMedicalService {
    public void save(Medical medical);
    public List<MedicalDTO> findAll();
    public void delete(Long id);
    public MedicalDTO findById(Long id);
    public MedicalDTO edit(Long id, String name, String description, double cost);
}
