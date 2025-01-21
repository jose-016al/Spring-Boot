package com.example.Ejercicio3.repository;

import com.example.Ejercicio3.model.Equipo;
import com.example.Ejercicio3.model.Piloto;
import com.example.Ejercicio3.service.EquipoService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EquipoRepository {

    private List<Equipo> equipos = new ArrayList<>();

    public List<Equipo> findAll() {
        return equipos;
    }

    public void save( Long id, String nombre, String pais, List<Piloto> pilotos) {
        equipos.add(new Equipo(id, nombre, pais, pilotos));
    }

    public Optional<Equipo> findByName(String name) {
        return equipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(name))
                .findFirst();
    }

    public Optional<List<Piloto>> findPilotosByEquipo(String name) {
        return equipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(name))
                .map(Equipo::getPilotos)
                .findFirst();
    }
}
