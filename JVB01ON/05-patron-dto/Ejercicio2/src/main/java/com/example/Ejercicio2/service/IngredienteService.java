package com.example.Ejercicio2.service;

import com.example.Ejercicio2.model.Ingrediente;
import com.example.Ejercicio2.repository.IngredienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class IngredienteService implements IIngredienteService {

    private IngredienteRepository ingredienteRepository = new IngredienteRepository();

    @Override
    public List<Ingrediente> findAll() {
        return ingredienteRepository.findAll();
    }

    @Override
    public String save(Ingrediente ingrediente) {
        ingredienteRepository.save(ingrediente);
        return "Ingrediente añadido correctamente";
    }

    @Override
    public Ingrediente findById(Long id) {
        return ingredienteRepository.findById(id)
                .orElseThrow(() -> new IllegalCallerException("El ingrediente con ID " + id + " no se ha encontrado"));
    }
}
