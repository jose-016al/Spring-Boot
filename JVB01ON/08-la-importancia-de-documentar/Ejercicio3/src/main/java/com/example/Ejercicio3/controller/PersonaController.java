package com.example.Ejercicio3.controller;

import com.example.Ejercicio3.modal.Persona;
import com.example.Ejercicio3.service.IPersonaService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
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

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "La operación se ejecuto correctamente"),
            @ApiResponse(responseCode = "204", description = "No se encontró la persona que intenta editar"),
    })
    @PutMapping("/edit/{id}")
    public ResponseEntity<Persona> edit(@PathVariable Long id,
                               @RequestParam ("nombre") String nombreEdit,
                               @RequestParam ("apellido") String apellidoEdit,
                               @RequestParam ("edad") int edadEdit) {
        Persona persona = service.findById(id, nombreEdit, apellidoEdit, edadEdit);
        if (persona == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(persona);
        }
    }

    @GetMapping("/{name}")
    public ResponseEntity<Persona> findByName(@PathVariable String name) {
        Persona persona = service.findByName(name);
        if (persona == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(persona);
        }
    }
}
