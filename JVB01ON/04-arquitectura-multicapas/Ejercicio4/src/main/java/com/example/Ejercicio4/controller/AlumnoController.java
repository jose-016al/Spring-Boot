package com.example.Ejercicio4.controller;

import com.example.Ejercicio4.model.Alumno;
import com.example.Ejercicio4.service.AlumnoService;
import com.example.Ejercicio4.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {

    // AlumnoService service = new AlumnoService();
    @Autowired
    private IAlumnoService service;

    @GetMapping
    public List<Alumno> findAll() {
        return service.findAll();
    }

    @PostMapping
    public String save(@RequestBody Alumno newAlumno) {
        service.save(newAlumno);
        return "Alumno añadido correctamente";
    }

    @GetMapping("/{id}")
    public Alumno findAlumno(@PathVariable Long id) {
        return service.findById(id);
    }

    @GetMapping("/level")
    public List<Alumno> findByLevel(@RequestParam String levelParam) {
        return service.findByLevel(levelParam);
    }
}
