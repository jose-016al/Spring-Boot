package com.example.Ejercicio2.repository;

import com.example.Ejercicio2.model.Alumno;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AlumnoRepository {

    private final List<Alumno> alumnos = new ArrayList<>();

    public List<Alumno> findAll() {
        return alumnos;
    }

    public void save(Alumno alumno) {
        alumnos.add(alumno);
    }

    public Optional<Alumno> findById(Long id) {
        return alumnos.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public List<Alumno> findByLevel(String level) {
        return alumnos.stream()
                .filter(a -> a.getNivelEducativo().equalsIgnoreCase(level))
                .toList();
    }
}
