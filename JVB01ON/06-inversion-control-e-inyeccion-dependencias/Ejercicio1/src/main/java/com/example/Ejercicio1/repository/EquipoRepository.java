package com.example.Ejercicio1.repository;

import com.example.Ejercicio1.model.Equipo;
import com.example.Ejercicio1.model.Jugador;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class EquipoRepository {

    List<Equipo> equipos = Arrays.asList(
            new Equipo(1L, "Real Madrid", "Madrid", Arrays.asList(
                    new Jugador(1L, "Karim Benzema", 35, "Delantero"),
                    new Jugador(2L, "Luka Modric", 38, "Centrocampista")
            )),
            new Equipo(2L, "Barcelona", "Barcelona", Arrays.asList(
                    new Jugador(3L, "Robert Lewandowski", 34, "Delantero"),
                    new Jugador(4L, "Pedri", 20, "Centrocampista")
            )),
            new Equipo(3L, "Manchester City", "Manchester", Arrays.asList(
                    new Jugador(5L, "Erling Haaland", 23, "Delantero"),
                    new Jugador(6L, "Kevin De Bruyne", 32, "Centrocampista")
            ))
    );

    public List<Equipo> findAll() {
        return equipos;
    }

    public Optional<Equipo> findById(Long id) {
        return equipos.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst();
    }

}
