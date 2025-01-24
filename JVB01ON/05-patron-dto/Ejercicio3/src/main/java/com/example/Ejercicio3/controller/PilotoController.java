package com.example.Ejercicio3.controller;

import com.example.Ejercicio3.dto.PilotosDTO;
import com.example.Ejercicio3.model.Piloto;
import com.example.Ejercicio3.service.PilotoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pilotos")
public class PilotoController {

    private PilotoService pilotoService = new PilotoService();

    @GetMapping("/traer")
    public List<Piloto> getPilotos() {
        return pilotoService.findAll();
    }

    @GetMapping("/traer/{name}")
    public PilotosDTO findPilotosByEquipo(@PathVariable String name) {
        return pilotoService.findPilotosByEquipo(name);
    }
}
