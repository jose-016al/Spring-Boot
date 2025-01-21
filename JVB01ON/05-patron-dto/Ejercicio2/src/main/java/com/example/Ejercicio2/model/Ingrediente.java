package com.example.Ejercicio2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class Ingrediente {
    private Long id;
    private String nombre;
    private String aptoCeliaco;
}
