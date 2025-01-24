package com.example.Ejercicio3.service;

import com.example.Ejercicio3.dto.PilotosDTO;
import com.example.Ejercicio3.model.Equipo;
import com.example.Ejercicio3.model.Piloto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EquipoService implements IEquipoService {

    List<Equipo> equipos = new ArrayList<>(List.of(
            new Equipo(1L, "Mercedes-AMG Petronas", "Alemania", List.of(
                    new Piloto(1L, "Lewis", "Hamilton", 38, "Reino Unido"),
                    new Piloto(2L, "George", "Russell", 25, "Reino Unido")
            )),
            new Equipo(2L, "Red Bull Racing", "Austria", List.of(
                    new Piloto(3L, "Max", "Verstappen", 27, "Países Bajos"),
                    new Piloto(4L, "Sergio", "Pérez", 33, "México")
            )),
            new Equipo(3L, "Scuderia Ferrari", "Italia", List.of(
                    new Piloto(5L, "Charles", "Leclerc", 26, "Mónaco"),
                    new Piloto(6L, "Carlos", "Sainz", 29, "España")
            ))
    ));

    @Override
    public List<Equipo> findAll() {
        return equipos;
    }

    @Override
    public String save(Equipo equipo) {

        boolean nacionalidadesCoinciden = equipo.getPilotos().stream()
                .allMatch(piloto -> piloto.getNacionalidad().equalsIgnoreCase(equipo.getPais()));

        if (!nacionalidadesCoinciden) {
            return "Todos los pilotos deben tener la misma nacionalidad que el equipo.";
        } else {
            equipos.add(equipo);
            return "Equipo añadido correctamente";
        }
    }

    @Override
    public Equipo findByName(String name) {
        return equipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @Override
    public PilotosDTO findPilotosByEquipo(String name) {
        return equipos.stream()
                .filter(equipo -> equipo.getNombre().equalsIgnoreCase(name))
                .map(equipo -> new PilotosDTO(
                        equipo.getNombre(),
                        equipo.getPilotos().stream()
                                .map(piloto -> piloto.getNombre() + " " + piloto.getApellido()).toList()
                ))
                .findFirst()
                .orElse(null);
    }
}
