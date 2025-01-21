package com.example.Ejercicio3.service;

import com.example.Ejercicio3.model.Equipo;
import com.example.Ejercicio3.model.Piloto;

import java.util.List;

public interface IEquipoService {
    public List<Equipo> findAll();
    public String save(Long id, String nombre, String pais, List<Piloto> pilotos);
    public Equipo findByName(String name);
    public List<Piloto> findPilotosByEquipo(String name);
}