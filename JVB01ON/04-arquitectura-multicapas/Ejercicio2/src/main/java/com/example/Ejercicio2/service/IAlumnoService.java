package com.example.Ejercicio2.service;

import com.example.Ejercicio2.model.Alumno;

import java.util.List;

public interface IAlumnoService {

    public List<Alumno> findAll();
    public String save(Alumno alumno);
    public Alumno findById(Long id);
    public List<Alumno> findByLevel(String level);

}
