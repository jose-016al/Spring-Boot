package com.example.Ejercicio3.service;

import com.example.Ejercicio3.dto.PilotosDTO;
import com.example.Ejercicio3.model.Piloto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PilotoService implements IPilotoService {

    private EquipoService service = new EquipoService();

    @Override
    public List<Piloto> findAll() {
        return service.findAll().stream().flatMap(equipo -> equipo.getPilotos().stream()).toList();
    }

    @Override
    public Piloto findById(Long id) {
        return findAll().stream()
                .filter(piloto -> piloto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public PilotosDTO findPilotosByEquipo(String name) {
        return service.findPilotosByEquipo(name);
    }
}
