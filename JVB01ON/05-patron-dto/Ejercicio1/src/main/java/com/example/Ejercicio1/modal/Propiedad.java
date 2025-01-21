package com.example.Ejercicio1.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Propiedad {
    private Long id;
    private String tipo;
    private String direccion;
    private double metrosCuadrados;
    private double valorAlquiler;
}