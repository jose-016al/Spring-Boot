package com.example.Ejercicio2.controller;

import com.example.Ejercicio2.dto.PlatosDTO;
import com.example.Ejercicio2.model.Plato;
import com.example.Ejercicio2.repository.PlatoRepository;
import com.example.Ejercicio2.service.PlatoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/platos")
public class PlatoController {

    private PlatoService platoService = new PlatoService();

    @GetMapping
    public List<Plato> findAll() {
        return platoService.findAll();
    }

    @GetMapping("celiacos")
    public List<Plato> findCeliacos() {
        return platoService.findCeliacos();
    }

    @GetMapping("/celiacos/{id}")
    public PlatosDTO findCeliacosById(@PathVariable Long id) {
        PlatosDTO platosDTO = new PlatosDTO();

        Plato plato = platoService.findCeliacosById(id);

        if (plato == null) {
            plato = platoService.findById(id);
            if (plato != null) {
                platosDTO.setNombre(plato.getNombre());
                platosDTO.setApto("No");
            }
        } else {
            platosDTO.setNombre(plato.getNombre());
            platosDTO.setApto("Si");
        }

        return  platosDTO;
    }

}