package com.example.cursos.controller;

import com.example.cursos.dto.SubjectRequestDTO;
import com.example.cursos.dto.SubjectResponseDTO;
import com.example.cursos.model.Subject;
import com.example.cursos.service.ISubjectService;
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
@RequestMapping("/temas")
@RequiredArgsConstructor
@Tag(name = "Temas")
public class SubjectController {

    private final ISubjectService subjectService;

    @Operation(
            summary = "Crear un nuevo tema",
            description = "Crea un nuevo tema asociado a un curso. Los datos deben ser proporcionados en el cuerpo de la solicitud."
    )
    @ApiResponse(responseCode = "201", description = "Tema creado correctamente")
    @ApiResponse(responseCode = "400", description = "Error en la validación de los datos proporcionados")
    @ApiResponse(responseCode = "401", description = "No autenticado. Se requiere autenticación")
    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid SubjectRequestDTO request) {
        subjectService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Se ha creado el tema");
    }

    @Operation(
            summary = "Obtener todos los temas de un curso",
            description = "Obtiene una lista de temas asociados a un curso específico mediante el ID del curso."
    )
    @ApiResponse(responseCode = "200", description = "Lista de temas obtenida correctamente")
    @ApiResponse(responseCode = "401", description = "No autenticado. Se requiere autenticación")
    @ApiResponse(responseCode = "404", description = "Curso no encontrado por el ID proporcionado")
    @GetMapping("/{id}")
    public ResponseEntity<List<SubjectResponseDTO>> findByCourse(@PathVariable Long id) {
        return ResponseEntity.ok(subjectService.findByCourse(id));
    }

    @Operation(
            summary = "Actualizar un tema existente",
            description = "Actualiza la información de un tema específico mediante el ID del tema y los datos proporcionados."
    )
    @ApiResponse(responseCode = "200", description = "Tema actualizado correctamente")
    @ApiResponse(responseCode = "401", description = "No autenticado. Se requiere autenticación")
    @ApiResponse(responseCode = "400", description = "Error de validación. Los datos proporcionados no son válidos")
    @ApiResponse(responseCode = "404", description = "Tema no encontrado con el ID proporcionado")
    @PutMapping("/{id}")
    public ResponseEntity<SubjectResponseDTO> update(@PathVariable Long id,
                                                     @RequestBody @Valid SubjectRequestDTO request) {
        return ResponseEntity.ok(subjectService.update(id, request));
    }

    @Operation(
            summary = "Eliminar un tema",
            description = "Elimina un tema existente a partir de su ID."
    )
    @ApiResponse(responseCode = "204", description = "Tema eliminado correctamente")
    @ApiResponse(responseCode = "401", description = "No autenticado. Se requiere autenticación")
    @ApiResponse(responseCode = "404", description = "Tema no encontrado con el ID proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        subjectService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
