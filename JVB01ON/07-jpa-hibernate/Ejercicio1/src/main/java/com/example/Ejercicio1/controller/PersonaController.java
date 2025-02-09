package com.example.Ejercicio1.controller;

import com.example.Ejercicio1.dto.PersonaRequestDTO;
import com.example.Ejercicio1.dto.PersonaResponseDTO;
import com.example.Ejercicio1.modal.Persona;
import com.example.Ejercicio1.service.IPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
@RequiredArgsConstructor
public class PersonaController {

    private final IPersonaService service;

    @GetMapping
    public List<PersonaResponseDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public String save(@RequestBody PersonaRequestDTO persona) {
        service.save(persona);
        return "Persona añadida correctamente";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Persona eliminada correctamente";
    }

    @PutMapping("/edit/{id}")
    public PersonaResponseDTO update(@PathVariable Long id, @RequestBody PersonaRequestDTO persona) {
        return service.update(id, persona);
    }
}
