package com.example.Ejercicio4.service;

import com.example.Ejercicio4.model.Alumno;

import java.util.List;

public interface IAlumnoService {
    public List<Alumno> findAll();
    public String save(Alumno newAlumno);
    public Alumno findById(Long id);
    public List<Alumno> findByLevel(String levelParam);
}
