package com.example.Ejercicio2.controller;

import com.example.Ejercicio2.model.Alumno;
import com.example.Ejercicio2.service.AlumnoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    AlumnoService alumnoService = new AlumnoService();

    @GetMapping
    public List<Alumno> findAll() {
        return alumnoService.findAll();
    }

    @PostMapping
    public String save(@RequestBody Alumno alumno) {
        return alumnoService.save(alumno);
    }

    @GetMapping("/{id}")
    public Alumno findById(@PathVariable Long id) {
        return alumnoService.findById(id);
    }

    @GetMapping("/level")
    public List<Alumno> findByLevel(@RequestParam String level) {
        return alumnoService.findByLevel(level);
    }
}
