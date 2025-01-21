package com.example.Ejercicio3.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Empleado {
    private Long id;
    private Integer legajo;
    private String nombre;
    private String apellido;
    private double sueldo;
}
