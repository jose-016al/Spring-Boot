package com.example.Ejercicio2.service;

import com.example.Ejercicio2.model.Alumno;
import com.example.Ejercicio2.repository.AlumnoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlumnoService implements IAlumnoService {

    private AlumnoRepository alumnoRepository = new AlumnoRepository();

    @Override
    public List<Alumno> findAll() {
        return alumnoRepository.findAll();
    }

    @Override
    public String save(Alumno alumno) {
        alumnoRepository.save(alumno);
        return "Alumno añadido correctamente";
    }

    @Override
    public Alumno findById(Long id) {
        return alumnoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Alumno con ID " + id + " no encontrado"));
    }

    @Override
    public List<Alumno> findByLevel(String level) {
        return alumnoRepository.findByLevel(level);
    }
}
