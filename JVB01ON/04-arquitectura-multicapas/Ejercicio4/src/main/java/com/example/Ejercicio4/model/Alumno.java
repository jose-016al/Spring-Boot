package com.example.Ejercicio4.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Alumno {
    private Long id;
    private String nombre;
    private String apellido;
    private String numeroMatricula;
    private double notaFinal;
    private String nivelEducativo;
}
