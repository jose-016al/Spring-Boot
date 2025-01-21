package com.example.Ejercicio3.controller;

import com.example.Ejercicio3.dto.PilotosDTO;
import com.example.Ejercicio3.model.Equipo;
import com.example.Ejercicio3.model.Piloto;
import com.example.Ejercicio3.repository.EquipoRepository;
import com.example.Ejercicio3.repository.PilotoRepository;
import com.example.Ejercicio3.service.EquipoService;
import com.example.Ejercicio3.service.PilotoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    private PilotoService pilotoService = new PilotoService();
    private EquipoService equipoService = new EquipoService();

        // Pilotos controller
    @GetMapping("/pilotos/traer")
    public List<Piloto> getPilotos() {
        return pilotoService.findAll();
    }

    @PostMapping("/pilotos/add")
    public String addPiloto(@RequestBody Piloto piloto) {
        return pilotoService.save(piloto);
    }

    @GetMapping("/pilotos/traer/{name}")
    public PilotosDTO findPilotosByEquipo(@PathVariable String name) {
        PilotosDTO pilotosDTO = new PilotosDTO();
        pilotosDTO.setEquipo(name);
        pilotosDTO.setPilotos(equipoService.findPilotosByEquipo(name).stream()
                .map(piloto -> Map.of(
                        "nombre", piloto.getNombre(),
                        "apellido", piloto.getApellido()
                ))
                .toList());
        return pilotosDTO;
    }

        // Equipos Controller
    @GetMapping("/equipos/traer")
    public List<Equipo> finAll() {
        return equipoService.findAll();
    }

    @PostMapping("/equipos/add")
    public String addEquipo(@RequestParam Long id,
                      @RequestParam String nombre,
                      @RequestParam String pais,
                      @RequestParam List<Long> pilotosIds) {

        List<Piloto> pilotos = pilotosIds.stream()
                .map(idPiloto -> pilotoService.findById(idPiloto))
                .toList();

        boolean nacionalidadesCoinciden = pilotos.stream()
                .allMatch(piloto -> piloto.getNacionalidad().equalsIgnoreCase(pais));

        if (!nacionalidadesCoinciden) {
            throw new IllegalArgumentException("Todos los pilotos deben tener la misma nacionalidad que el equipo.");
        }

        return equipoService.save(id, nombre, pais, pilotos);
    }

    @GetMapping("/equipos/traer/{name}")
    public Equipo findByName(@PathVariable String name) {
        return equipoService.findByName(name);
    }

}
