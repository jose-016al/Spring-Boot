package com.example.Ejercicio1.service;

import com.example.Ejercicio1.modal.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> findAll();
    public void save(Persona persona);
    public void delete(Long id);
    public Persona findById(Long id);
}
