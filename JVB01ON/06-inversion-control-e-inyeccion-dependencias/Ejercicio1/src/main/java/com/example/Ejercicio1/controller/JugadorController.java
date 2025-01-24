package com.example.Ejercicio1.controller;

import com.example.Ejercicio1.model.Jugador;
import com.example.Ejercicio1.service.IJugadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/jugadores")
public class JugadorController {

    @Autowired
    private IJugadorService service;

    @GetMapping
    public List<Jugador> findAll() {
        return service.findAll();
    }
}
