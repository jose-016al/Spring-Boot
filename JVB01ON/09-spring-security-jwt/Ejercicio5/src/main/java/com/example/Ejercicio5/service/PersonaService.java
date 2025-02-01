package com.example.Ejercicio5.service;

import com.example.Ejercicio5.modal.Persona;
import com.example.Ejercicio5.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonaService implements IPersonaService {

    @Autowired
    private PersonaRepository repository;

    @Override
    public List<Persona> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Persona persona) {
        repository.save(persona);
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Persona findById(Long id, String nombreEdit, String apellidoEdit, int edadEdit) {
        return repository.findById(id)
                .map(persona -> {
                    persona.setNombre(nombreEdit);
                    persona.setApellido(apellidoEdit);
                    persona.setEdad(edadEdit);
                    return persona;
                })
                .orElse(null);
    }

    @Override
    public Persona findByName(String name) {
        return repository.findByNombre(name).orElse(null);
    }
}
