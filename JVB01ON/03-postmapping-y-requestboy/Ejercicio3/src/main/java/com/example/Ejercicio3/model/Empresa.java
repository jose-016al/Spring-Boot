package com.example.Ejercicio3.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Empresa {
    private Long id;
    private String nombre;
    private List<Empleado> empleados;
}
