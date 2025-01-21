package com.example.Ejercicio3.dto;

import com.example.Ejercicio3.model.Piloto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter @Setter
public class PilotosDTO {
    private String equipo;
    private List<Map<String, String>> pilotos;
}