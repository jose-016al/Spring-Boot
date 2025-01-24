package com.example.Ejercicio1.service;

import com.example.Ejercicio1.dto.JugadoresEquipoDTO;
import com.example.Ejercicio1.model.Equipo;
import com.example.Ejercicio1.model.Jugador;
import com.example.Ejercicio1.repository.EquipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

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
        return repository.findById(id).orElse(null);
    }

    @Override
    public JugadoresEquipoDTO findJugadoresById(@PathVariable Long id) {
        return findAll().stream()
                .filter(equipo -> equipo.getId().equals(id))
                .findFirst()
                .map(equipo -> new JugadoresEquipoDTO(
                        equipo.getNombre(),
                        equipo.getJugadores().stream().map(Jugador::getNombre).toList()
                ))
                .orElse(null);
    }
}
