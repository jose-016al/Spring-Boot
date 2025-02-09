package com.example.Ejercicio1.service;

import com.example.Ejercicio1.dto.PersonaRequestDTO;
import com.example.Ejercicio1.dto.PersonaResponseDTO;
import com.example.Ejercicio1.modal.Persona;
import com.example.Ejercicio1.repository.PersonaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonaService implements IPersonaService {

    private final PersonaRepository repository;

    @Override
    public List<PersonaResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(persona -> PersonaResponseDTO.builder()
                        .id(persona.getId())
                        .name(persona.getName())
                        .surname(persona.getSurname())
                        .age(persona.getAge())
                        .build()
                )
                .toList();
    }

    @Override
    public void save(PersonaRequestDTO persona) {
        repository.save(Persona.builder()
                .name(persona.getName())
                .surname(persona.getSurname())
                .age(persona.getAge())
                .build()
        );
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public PersonaResponseDTO update(Long id, PersonaRequestDTO request) {
        Optional<Persona> optionalPersona = repository.findById(id);

        if (optionalPersona.isEmpty()) {
            return null;
        }

        Persona persona = optionalPersona.get();
        persona.setName(request.getName());
        persona.setSurname(request.getSurname());
        persona.setAge(request.getAge());

        repository.save(persona);

        return PersonaResponseDTO.builder()
                .id(persona.getId())
                .name(persona.getName())
                .surname(persona.getSurname())
                .age(persona.getAge())
                .build();
    }
}
