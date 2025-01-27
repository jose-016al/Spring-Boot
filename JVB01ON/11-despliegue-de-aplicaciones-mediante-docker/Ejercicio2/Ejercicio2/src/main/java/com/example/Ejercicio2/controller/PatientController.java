package com.example.Ejercicio2.controller;

import com.example.Ejercicio2.dto.PatientDTO;
import com.example.Ejercicio2.model.Patient;
import com.example.Ejercicio2.service.IPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pacientes")
public class PatientController {

    @Autowired
    private IPatientService service;

    @PostMapping("/registrar")
    public ResponseEntity<String> save(@RequestBody Patient patient) {
        service.save(patient);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Paciente registrado correctamente");
    }

    @GetMapping("/lista")
    public ResponseEntity<List<PatientDTO>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable Long id) {
        boolean isDeleted = service.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Paciente no encontrado con el ID: " + id));
        }
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Map<String, Object>> findById(@PathVariable Long id) {
        PatientDTO patient = service.findById(id);
        if (patient != null) {
            return ResponseEntity.ok(Map.of("patient", patient));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "Paciente no encontrado con el ID: " + id));
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Map<String, Object>> edit(@PathVariable Long id,
                                                    @RequestParam("name") String name,
                                                    @RequestParam("surname") String surname,
                                                    @RequestParam("age") int age) {
        PatientDTO updatedPatient = service.edit(id, name, surname, age);
        if (updatedPatient != null) {
            return ResponseEntity.ok(Map.of("patient", updatedPatient));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("error", "No se pudo actualizar. Paciente no encontrado con el ID: " + id));
        }
    }
}