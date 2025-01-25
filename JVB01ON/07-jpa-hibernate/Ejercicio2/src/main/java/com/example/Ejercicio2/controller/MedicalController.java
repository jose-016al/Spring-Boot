package com.example.Ejercicio2.controller;

import com.example.Ejercicio2.dto.MedicalDTO;
import com.example.Ejercicio2.model.Medical;
import com.example.Ejercicio2.service.IMedicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/servicios")
public class MedicalController {

    @Autowired
    private IMedicalService service;

    @PostMapping("/agregar")
    public String save(@RequestBody Medical medical) {
        service.save(medical);
        return "Servicio medicado añadido";
    }

    @GetMapping("/lista")
    public List<MedicalDTO> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Servicio medico eliminado";
    }

    @GetMapping("/buscar/{id}")
    public MedicalDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/editar/{id}")
    public MedicalDTO edit(@PathVariable Long id,
                           @RequestParam ("name") String name,
                           @RequestParam ("description") String description,
                           @RequestParam ("cost") double cost) {
        return service.edit(id, name, description, cost);
    }
}
