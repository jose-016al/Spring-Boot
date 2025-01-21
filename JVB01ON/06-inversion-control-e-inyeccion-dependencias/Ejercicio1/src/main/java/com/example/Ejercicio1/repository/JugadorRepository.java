package com.example.Ejercicio1.repository;

import com.example.Ejercicio1.model.Equipo;
import com.example.Ejercicio1.model.Jugador;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class JugadorRepository {

    List<Jugador> jugadores = Arrays.asList(
            new Jugador(1L, "Karim Benzema", 35, "Delantero"),
            new Jugador(2L, "Luka Modric", 38, "Centrocampista"),
            new Jugador(3L, "Robert Lewandowski", 34, "Delantero"),
            new Jugador(4L, "Pedri", 20, "Centrocampista"),
            new Jugador(5L, "Erling Haaland", 23, "Delantero"),
            new Jugador(6L, "Kevin De Bruyne", 32, "Centrocampista")
    );

    public List<Jugador> findAll() {
        return jugadores;
    }

    public Optional<Jugador> findById(Long id) {
        return jugadores.stream()
                .filter(j -> j.getId().equals(id))
                .findFirst();
    }
}
