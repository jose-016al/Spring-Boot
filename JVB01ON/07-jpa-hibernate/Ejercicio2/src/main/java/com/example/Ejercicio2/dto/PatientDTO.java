package com.example.Ejercicio2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class PatientDTO {
    private String name;
    private String surname;
    private int age;
}
