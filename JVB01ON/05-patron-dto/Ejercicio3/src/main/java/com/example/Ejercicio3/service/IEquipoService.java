package com.example.Ejercicio3.service;

import com.example.Ejercicio3.dto.PilotosDTO;
import com.example.Ejercicio3.model.Equipo;
import com.example.Ejercicio3.model.Piloto;

import java.util.List;

public interface IEquipoService {
    public List<Equipo> findAll();
    public String save(Equipo equipo);
    public Equipo findByName(String name);
    public PilotosDTO findPilotosByEquipo(String name);
}