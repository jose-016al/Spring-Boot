package com.example.Ejercicio1.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class PropiedadDTO implements Serializable {
    private Long id;
    private String tipo;
    private String direccion;
    private double valorAlquiler;
    private String nombre;
    private String apellido;
}