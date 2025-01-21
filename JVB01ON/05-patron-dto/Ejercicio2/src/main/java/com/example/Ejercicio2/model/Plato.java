package com.example.Ejercicio2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class Plato {
    private Long id;
    private String nombre;
    private double precio;
    private List<Ingrediente> ingredientes;
}
