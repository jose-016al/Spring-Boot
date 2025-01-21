package com.example.Ejercicio1.service;

import com.example.Ejercicio1.model.Equipo;
import com.example.Ejercicio1.model.Jugador;

import java.util.List;

public interface IEquipoService {
    public List<Equipo> findAll();
    public Equipo findById(Long id);
    public List<Jugador> findJugadoresById(Long id);
}
