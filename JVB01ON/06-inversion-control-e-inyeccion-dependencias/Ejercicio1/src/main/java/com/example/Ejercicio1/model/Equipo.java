package com.example.Ejercicio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class Equipo {
    private Long id;
    private String nombre;
    private String ciudad;
    private List<Jugador> jugadores;
}
