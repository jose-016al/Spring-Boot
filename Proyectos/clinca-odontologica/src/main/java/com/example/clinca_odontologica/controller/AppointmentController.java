package com.example.clinca_odontologica.controller;

import com.example.clinca_odontologica.dto.AppointmentRequestDTO;
import com.example.clinca_odontologica.dto.AppointmentResponseDTO;
import com.example.clinca_odontologica.service.IAppointmentService;
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
@RequestMapping("/turnos")
@RequiredArgsConstructor
@Tag(name = "Turnos")
public class AppointmentController {

    private final IAppointmentService appointmentService;

    @Operation(summary = "Crea un nuevo turno", description = "Registra un nuevo turno con la información proporcionada.")
    @ApiResponse(responseCode = "201", description = "Turno creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @PostMapping
    public ResponseEntity<AppointmentResponseDTO> save(@RequestBody @Valid AppointmentRequestDTO request) {
        return new ResponseEntity<>(appointmentService.save(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Obtiene todos los turnos", description = "Devuelve una lista con todos los turnos registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de turnos obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<AppointmentResponseDTO>> findAll() {
        return ResponseEntity.ok(appointmentService.findAll());
    }

    @Operation(summary = "Actualiza un turno", description = "Modifica un turno existente según el ID proporcionado.")
    @ApiResponse(responseCode = "200", description = "Turno actualizado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @PutMapping("/{id}")
    public ResponseEntity<AppointmentResponseDTO> update(@PathVariable Long id,
                                                     @RequestBody @Valid AppointmentRequestDTO request) {
        return ResponseEntity.ok(appointmentService.update(id, request));
    }

    @Operation(summary = "Elimina un turno", description = "Elimina un turno existente según el ID proporcionado.")
    @ApiResponse(responseCode = "204", description = "Turno eliminado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        appointmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
