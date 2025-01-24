package com.example.Ejercicio2.service;

import com.example.Ejercicio2.dto.PlatoDTO;
import com.example.Ejercicio2.model.Plato;

import java.util.List;

public interface IPlatoService {
    public List<Plato> findAll();
    public String save(Plato plato);
    public Plato findById(Long id);
    public List<Plato> findCeliacos();
    public PlatoDTO findCeliacosById(Long id);
}
