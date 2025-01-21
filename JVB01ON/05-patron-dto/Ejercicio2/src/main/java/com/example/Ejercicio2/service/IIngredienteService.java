package com.example.Ejercicio2.service;

import com.example.Ejercicio2.model.Ingrediente;

import java.util.List;

public interface IIngredienteService {
    public List<Ingrediente> findAll();
    public String save(Ingrediente ingrediente);
    public Ingrediente findById(Long id);
}
