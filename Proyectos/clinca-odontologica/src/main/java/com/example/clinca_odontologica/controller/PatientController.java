package com.example.clinca_odontologica.controller;

import com.example.clinca_odontologica.dto.PatientRequestDTO;
import com.example.clinca_odontologica.dto.PatientResponseDTO;
import com.example.clinca_odontologica.service.IPatientService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
@Tag(name = "Pacientes")
public class PatientController {

    private final IPatientService patientService;

    @Operation(summary = "Crea un nuevo paciente", description = "Registra un nuevo paciente con la información proporcionada.")
    @ApiResponse(responseCode = "201", description = "Paciente creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @PostMapping
    public ResponseEntity<PatientResponseDTO> save(@RequestBody @Valid PatientRequestDTO request) {
        return new ResponseEntity<>(patientService.save(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Obtiene todos los pacientes", description = "Devuelve una lista con todos los pacientes registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de pacientes obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<PatientResponseDTO>> findAll() {
        return ResponseEntity.ok(patientService.findAll());
    }

    @Operation(summary = "Actualiza un paciente", description = "Modifica un paciente existente según el ID proporcionado.")
    @ApiResponse(responseCode = "200", description = "Paciente actualizado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @PutMapping("/{id}")
    public ResponseEntity<PatientResponseDTO> update(@PathVariable Long id,
                                                     @RequestBody @Valid PatientRequestDTO request) {
        return ResponseEntity.ok(patientService.update(id, request));
    }

    @Operation(summary = "Elimina un paciente", description = "Elimina un paciente existente según el ID proporcionado.")
    @ApiResponse(responseCode = "204", description = "Paciente eliminado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        patientService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
