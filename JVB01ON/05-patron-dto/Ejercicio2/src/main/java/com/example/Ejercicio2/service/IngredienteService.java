package com.example.Ejercicio2.service;

import com.example.Ejercicio2.model.Ingrediente;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IngredienteService implements IIngredienteService {

    private List<Ingrediente> ingredientes = new ArrayList<>();

    @Override
    public List<Ingrediente> findAll() {
        return ingredientes;
    }

    @Override
    public String save(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
        return "Ingrediente añadido correctamente";
    }

    @Override
    public Ingrediente findById(Long id) {
        return ingredientes.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
