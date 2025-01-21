package com.example.Ejercicio3.service;

import com.example.Ejercicio3.model.Equipo;
import com.example.Ejercicio3.model.Piloto;
import com.example.Ejercicio3.repository.EquipoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EquipoService implements IEquipoService {

    private EquipoRepository equipoRepository = new EquipoRepository();

    @Override
    public List<Equipo> findAll() {
        return equipoRepository.findAll();
    }

    @Override
    public String save(Long id, String nombre, String pais, List<Piloto> pilotos) {
        equipoRepository.save(id, nombre, pais, pilotos);
        return "Equipo añadido correctamente";
    }

    @Override
    public Equipo findByName(String name) {
        return equipoRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el equipo"));
    }

    @Override
    public List<Piloto> findPilotosByEquipo(String name) {
        return equipoRepository.findPilotosByEquipo(name)
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el equipo"));
    }
}
