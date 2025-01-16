package com.example.Ejercicio2.controller;

import com.example.Ejercicio2.model.Alumno;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    List<Alumno> alumnos = new ArrayList<>();

    @GetMapping
    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    @PostMapping("/add")
    public String add(@RequestBody Alumno newAlumno) {
        alumnos.add(newAlumno);
        return "Alumno añadido correctamente";
    }

    @GetMapping("/{id}")
    public Alumno getAlumno(@PathVariable Long id) {
        return alumnos.stream()
                .filter(alumno -> alumno.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Alumno con ID " + id + " no encontrado"));
    }

    @GetMapping("/level")
    public List<Alumno> getAlumnoByLevel(@RequestParam String levelParam) {
        return alumnos.stream()
                .filter(alumno -> alumno.getNivelEducativo().equalsIgnoreCase(levelParam))
                .toList();
    }

}
