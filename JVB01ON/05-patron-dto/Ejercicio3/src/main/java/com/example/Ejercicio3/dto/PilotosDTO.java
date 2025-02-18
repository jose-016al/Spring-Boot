package com.example.Ejercicio3.dto;

import com.example.Ejercicio3.model.Piloto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
public class PilotosDTO {
    private String equipo;
    private List<String> pilotos;
}