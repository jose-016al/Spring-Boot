package com.example.Ejercicio1.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class JugadoresEquipoDTO {
    private String nombre;
    private List<String> jugadores;
}