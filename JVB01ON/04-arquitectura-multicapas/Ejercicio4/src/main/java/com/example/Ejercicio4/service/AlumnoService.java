package com.example.Ejercicio4.service;

import com.example.Ejercicio4.model.Alumno;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnoService implements IAlumnoService {

    List<Alumno> alumnos = new ArrayList<>();

    @Override
    public List<Alumno> findAll() {
        return alumnos;
    }

    @Override
    public String save(Alumno newAlumno) {
        alumnos.add(newAlumno);
        return "Alumno añadido correctamente";
    }

    @Override
    public Alumno findById(Long id) {
        return alumnos.stream()
                .filter(alumno -> alumno.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Alumno con ID " + id + " no encontrado"));
    }

    @Override
    public List<Alumno> findByLevel(String levelParam) {
        return alumnos.stream()
                .filter(alumno -> alumno.getNivelEducativo().equalsIgnoreCase(levelParam))
                .toList();
    }
}
