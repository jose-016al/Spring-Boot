package com.example.Ejercicio1.service;

import com.example.Ejercicio1.modal.Persona;
import com.example.Ejercicio1.repository.PersonaRepository;
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
    public Persona findById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
