package com.example.Ejercicio3.repository;

import com.example.Ejercicio3.model.Piloto;
import com.example.Ejercicio3.service.EquipoService;
import com.example.Ejercicio3.service.PilotoService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class PilotoRepository {

    private List<Piloto> pilotos = new ArrayList<>();

    private EquipoService equipoService = new EquipoService();

    public List<Piloto> findAll() {
        return pilotos;
    }

    public void save(Piloto piloto) {
        pilotos.add(piloto);
    }

    public Optional<Piloto> findById(Long id) {
        return pilotos.stream()
                .filter(piloto -> piloto.getId().equals(id))
                .findFirst();
    }

    public List<Piloto> findPilotosByEquipo(String name) {
        return equipoService.findPilotosByEquipo(name);
    }

}
