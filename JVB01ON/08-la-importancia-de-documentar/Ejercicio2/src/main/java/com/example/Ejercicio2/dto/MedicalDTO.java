package com.example.Ejercicio2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MedicalDTO {
    private String name;
    private String description;
    private double cost;
}
