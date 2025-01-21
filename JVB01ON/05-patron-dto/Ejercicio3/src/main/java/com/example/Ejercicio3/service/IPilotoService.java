package com.example.Ejercicio3.service;

import com.example.Ejercicio3.model.Piloto;

import java.util.List;

public interface IPilotoService {
    public List<Piloto> findAll();
    public String save(Piloto piloto);
    public Piloto findById(Long id);
    public List<Piloto> findPilotosByEquipo(String name);
}