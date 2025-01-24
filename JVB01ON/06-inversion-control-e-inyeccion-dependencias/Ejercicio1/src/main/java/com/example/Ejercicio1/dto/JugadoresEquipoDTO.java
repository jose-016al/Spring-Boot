package com.example.Ejercicio1.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
@AllArgsConstructor
public class JugadoresEquipoDTO {
    private String nombre;
    private List<String> jugadores;
}