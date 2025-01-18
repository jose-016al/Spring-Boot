package com.example.Ejercicio1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alumnos")
public class AlumnoController {


    @GetMapping
    public String getAlumnos() {
        Alumno alumno = new Alumno();
        alumno.setId(1);
        alumno.setNombre("Jose");
        alumno.setApellido("Perez");
        return alumno.getNombre();
    }

}
