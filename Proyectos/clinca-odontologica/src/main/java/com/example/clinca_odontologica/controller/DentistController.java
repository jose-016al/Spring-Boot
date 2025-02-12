package com.example.clinca_odontologica.controller;

import com.example.clinca_odontologica.dto.DentistRequestDTO;
import com.example.clinca_odontologica.dto.DentistResponseDTO;
import com.example.clinca_odontologica.service.IDentistService;
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
@RequestMapping("/dentistas")
@RequiredArgsConstructor
@Tag(name = "Dentistas")
public class DentistController {

    private final IDentistService dentistService;

    @Operation(summary = "Crea un nuevo dentista", description = "Registra un nuevo dentista con la información proporcionada.")
    @ApiResponse(responseCode = "201", description = "Dentista creado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @PostMapping
    public ResponseEntity<DentistResponseDTO> save(@RequestBody @Valid DentistRequestDTO request) {
        return new ResponseEntity<>(dentistService.save(request), HttpStatus.CREATED);
    }

    @Operation(summary = "Obtiene todos los dentistas", description = "Devuelve una lista con todos los dentistas registrados.")
    @ApiResponse(responseCode = "200", description = "Lista de dentistas obtenida exitosamente")
    @GetMapping
    public ResponseEntity<List<DentistResponseDTO>> findAll() {
        return ResponseEntity.ok(dentistService.findAll());
    }

    @Operation(summary = "Actualiza un dentista", description = "Modifica un dentista existente según el ID proporcionado.")
    @ApiResponse(responseCode = "200", description = "Dentista actualizado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @PutMapping("/{id}")
    public ResponseEntity<DentistResponseDTO> update(@PathVariable Long id,
                                                     @RequestBody @Valid DentistRequestDTO request) {
        return ResponseEntity.ok(dentistService.update(id, request));
    }

    @Operation(summary = "Elimina un dentista", description = "Elimina un dentista existente según el ID proporcionado.")
    @ApiResponse(responseCode = "204", description = "Dentista eliminado exitosamente")
    @ApiResponse(responseCode = "400", description = "Error en la solicitud, datos inválidos")
    @ApiResponse(responseCode = "401", description = "No autorizado para realizar esta acción")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        dentistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
