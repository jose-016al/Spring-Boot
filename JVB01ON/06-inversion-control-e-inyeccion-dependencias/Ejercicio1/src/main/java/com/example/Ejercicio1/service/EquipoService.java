package com.example.Ejercicio1.service;

import com.example.Ejercicio1.model.Equipo;
import com.example.Ejercicio1.model.Jugador;
import com.example.Ejercicio1.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipoService implements IEquipoService {

    @Autowired
    private EquipoRepository repository;

    @Override
    public List<Equipo> findAll() {
        return repository.findAll();
    }

    @Override
    public Equipo findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el equipo con ID" + id));
    }

    @Override
    public List<Jugador> findJugadoresById(Long id) {
        return findById(id).getJugadores();
    }
}
