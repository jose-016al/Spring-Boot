package com.example.Ejercicio2.controller;

import com.example.Ejercicio2.dto.PatientDTO;
import com.example.Ejercicio2.model.Patient;
import com.example.Ejercicio2.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    @Autowired
    private IPatientService service;

    @PostMapping("/registrar")
    public String save(@RequestBody Patient patient) {
        service.save(patient);
        return "Paciente registrado" + patient.getName();
    }

    @GetMapping("/lista")
    public List<PatientDTO> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/eliminar/{id}")
    public String delete(@PathVariable Long id) {
        service.delete(id);
        return "Paciente eliminado";
    }

    @GetMapping("/buscar/{id}")
    public PatientDTO findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PutMapping("/editar/{id}")
    public PatientDTO edit(@PathVariable Long id,
                           @RequestParam ("name") String name,
                           @RequestParam ("surname") String surname,
                           @RequestParam ("age") int age) {
        return service.edit(id, name, surname, age);
    }

}