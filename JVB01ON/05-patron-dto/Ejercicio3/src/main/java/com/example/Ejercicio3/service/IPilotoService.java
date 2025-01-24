package com.example.Ejercicio3.service;

import com.example.Ejercicio3.dto.PilotosDTO;
import com.example.Ejercicio3.model.Piloto;

import java.util.List;

public interface IPilotoService {
    public List<Piloto> findAll();
    public Piloto findById(Long id);
    public PilotosDTO findPilotosByEquipo(String name);
}