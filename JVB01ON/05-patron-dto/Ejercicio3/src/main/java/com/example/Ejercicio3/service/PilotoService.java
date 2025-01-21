package com.example.Ejercicio3.service;

import com.example.Ejercicio3.model.Piloto;
import com.example.Ejercicio3.repository.PilotoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PilotoService implements IPilotoService {

    private PilotoRepository pilotoRepository = new PilotoRepository();

    @Override
    public List<Piloto> findAll() {
        return pilotoRepository.findAll();
    }

    @Override
    public String save(Piloto piloto) {
        pilotoRepository.save(piloto);
        return "Piloto añadido correctamente";
    }

    @Override
    public Piloto findById(Long id) {
        return pilotoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No se ha encontrado el piloto"));
    }

    @Override
    public List<Piloto> findPilotosByEquipo(String name) {
        return pilotoRepository.findPilotosByEquipo(name);
    }
}
