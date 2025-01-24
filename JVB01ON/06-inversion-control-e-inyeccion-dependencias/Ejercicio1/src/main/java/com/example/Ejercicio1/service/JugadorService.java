package com.example.Ejercicio1.service;

import com.example.Ejercicio1.model.Jugador;
import com.example.Ejercicio1.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService implements  IJugadorService {

    @Autowired
    private EquipoRepository repository;

    @Override
    public List<Jugador> findAll() {
        return repository.findAll().stream()
                .flatMap(equipo -> equipo.getJugadores().stream())
                .toList();
    }
}
