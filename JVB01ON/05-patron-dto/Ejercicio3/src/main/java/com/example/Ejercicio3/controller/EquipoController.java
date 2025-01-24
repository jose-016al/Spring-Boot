package com.example.Ejercicio3.controller;

import com.example.Ejercicio3.model.Equipo;
import com.example.Ejercicio3.service.EquipoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EquipoController {

    private EquipoService equipoService = new EquipoService();

        // Equipos Controller
    @GetMapping("/equipos/traer")
    public List<Equipo> finAll() {
        return equipoService.findAll();
    }

    @PostMapping("/equipos/add")
    public String addEquipo(@RequestBody Equipo equipo) {
        return equipoService.save(equipo);
    }

    @GetMapping("/equipos/traer/{name}")
    public Equipo findByName(@PathVariable String name) {
        return equipoService.findByName(name);
    }

}
