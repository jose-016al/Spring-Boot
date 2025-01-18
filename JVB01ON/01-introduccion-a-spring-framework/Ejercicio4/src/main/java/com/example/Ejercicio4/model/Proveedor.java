package com.example.Ejercicio4.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Proveedor {
    private Long id;
    private String nombre;
    private String cargo;
}
