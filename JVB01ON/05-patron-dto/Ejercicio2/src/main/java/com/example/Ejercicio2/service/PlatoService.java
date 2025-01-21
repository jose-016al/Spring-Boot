package com.example.Ejercicio2.service;

import com.example.Ejercicio2.model.Ingrediente;
import com.example.Ejercicio2.model.Plato;
import com.example.Ejercicio2.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PlatoService implements IPlatoService {

    PlatoRepository platoRepository = new PlatoRepository();

    @Override
    public List<Plato> findAll() {
        return platoRepository.findAll();
    }

    @Override
    public String save(Plato plato) {
        platoRepository.save(plato);
        return "Plato añadido correctamente";
    }

    @Override
    public Plato findById(Long id) {
        return platoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Plato no encontrado"));
    }

    @Override
    public List<Plato> findCeliacos() {
        return platoRepository.findCeliacos();
    }

    @Override
    public Plato findCeliacosById(Long id) {
        return platoRepository.findCeliacosById(id)
                .orElse(null);
    }
}
