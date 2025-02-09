package com.example.Ejercicio1.dto;


import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class PersonaRequestDTO {
    private String name;
    private String surname;
    private int age;
}
