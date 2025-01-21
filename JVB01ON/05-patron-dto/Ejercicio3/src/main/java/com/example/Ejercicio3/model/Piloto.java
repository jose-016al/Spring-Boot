package com.example.Ejercicio3.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Piloto {
    private Long id;
    private String nombre;
    private String apellido;
    private int edad;
    private String nacionalidad;
}
