package com.example.Ejercicio1.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Jugador {
    private Long id;
    private String nombre;
    private int edad;
    private String posicion;
}
