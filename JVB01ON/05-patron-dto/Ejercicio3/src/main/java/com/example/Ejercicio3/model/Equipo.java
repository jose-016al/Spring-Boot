package com.example.Ejercicio3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class Equipo {
    private Long id;
    private String nombre;
    private String pais;
    private List<Piloto> pilotos;
}
