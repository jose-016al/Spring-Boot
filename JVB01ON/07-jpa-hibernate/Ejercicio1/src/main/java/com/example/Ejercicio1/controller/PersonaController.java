package com.example.Ejercicio1.controller;

import com.example.Ejercicio1.modal.Persona;
import com.example.Ejercicio1.service.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaController {

    @Autowired
    private IPersonaService service;

    @GetMapping
    public List<Persona> findAll() {
        return service.findAll();
    }

    @PostMapping
    public String save(@RequestBody Persona persona) {
        service.save(persona);
        return "Persona añadida correctamente";
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Persona eliminada correctamente";
    }

    @PutMapping("/edit/{id}")
    public Persona edit(@PathVariable Long id,
                        @RequestParam ("nombre") String nombreEdit,
                        @RequestParam ("apellido") String apellidoEdit,
                        @RequestParam ("edad") int edadEdit) {
        Persona persona = service.findById(id);
        persona.setNombre(nombreEdit);
        persona.setApellido(apellidoEdit);
        persona.setEdad(edadEdit);
        return persona;
    }
}
