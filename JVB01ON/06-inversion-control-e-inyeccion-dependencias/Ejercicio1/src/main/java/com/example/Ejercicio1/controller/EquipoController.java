package com.example.Ejercicio1.controller;

import com.example.Ejercicio1.dto.JugadoresEquipoDTO;
import com.example.Ejercicio1.model.Equipo;
import com.example.Ejercicio1.model.Jugador;
import com.example.Ejercicio1.service.IEquipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    @Autowired
    private IEquipoService service;

    @GetMapping
    public List<Equipo> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Equipo findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/{id}/jugadores")
    public JugadoresEquipoDTO findJugadorById(@PathVariable Long id) {
        JugadoresEquipoDTO jugadoresEquipoDTO = new JugadoresEquipoDTO();
        jugadoresEquipoDTO.setNombre(findById(id).getNombre());
        jugadoresEquipoDTO.setJugadores(findById(id).getJugadores().stream()
                .map(Jugador::getNombre)
                .toList()
        );
        return jugadoresEquipoDTO;
    }



}
