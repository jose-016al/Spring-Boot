package com.example.Ejercicio2.repository;

import com.example.Ejercicio2.model.Ingrediente;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class IngredienteRepository {

    private List<Ingrediente> ingredientes = new ArrayList<>();

    public List<Ingrediente> findAll() {
        return ingredientes;
    }

    public void save(Ingrediente ingrediente) {
        ingredientes.add(ingrediente);
    }

    public Optional<Ingrediente> findById(Long id) {
        return ingredientes.stream()
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }

}
