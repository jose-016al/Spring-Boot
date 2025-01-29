package com.example.Ejercicio3.service;

import com.example.Ejercicio3.modal.Persona;

import java.util.List;

public interface IPersonaService {
    public List<Persona> findAll();
    public void save(Persona persona);
    public void delete(Long id);
    public Persona findById(Long id, String nombreEdit, String apellidoEdit, int edadEdit);
    public Persona findByName(String name);
}
