package com.example.Ejercicio1.service;

import com.example.Ejercicio1.model.Jugador;
import com.example.Ejercicio1.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService implements  IJugadorService {

    @Autowired
    private JugadorRepository repository;

    @Override
    public List<Jugador> findAll() {
        return repository.findAll();
    }

    @Override
    public Jugador findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el jugador con ID: " + id));
    }
}
