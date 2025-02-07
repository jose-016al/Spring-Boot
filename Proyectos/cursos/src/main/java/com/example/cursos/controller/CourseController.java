package com.example.cursos.controller;

import com.example.cursos.dto.CourseRequestDTO;
import com.example.cursos.dto.CourseResponseDTO;
import com.example.cursos.service.ICourseService;
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
@RequestMapping("/cursos")
@RequiredArgsConstructor
@Tag(name = "Cursos")
public class CourseController {

    private final ICourseService courseService;

    @Operation(
            summary = "Registrar un nuevo curso",
            description = "Guarda un nuevo curso en el sistema. Se requiere autenticación."
    )
    @ApiResponse(responseCode = "201", description = "Curso registrado correctamente")
    @ApiResponse(responseCode = "400", description = "Error en la validación de los datos")
    @ApiResponse(responseCode = "401", description = "No autenticado")
    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid CourseRequestDTO request) {
        courseService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Curso registrado correctamente");
    }

    @Operation(
            summary = "Obtener todos los cursos",
            description = "Recupera una lista de todos los cursos disponibles en el sistema."
    )
    @ApiResponse(responseCode = "200", description = "Lista de cursos recuperada correctamente")
    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> findAll() {
        return ResponseEntity.ok(courseService.findAll());
    }

    @Operation(
            summary = "Buscar cursos por nombre",
            description = "Recupera una lista de cursos cuyo nombre contenga la palabra clave proporcionada."
    )
    @ApiResponse(responseCode = "200", description = "Lista de cursos recuperada correctamente")
    @ApiResponse(responseCode = "401", description = "No autenticado. Se requiere autenticación")
    @ApiResponse(responseCode = "404", description = "El parámetro de búsqueda no puede estar vacío")
    @GetMapping("/{name}")
    public ResponseEntity<List<CourseResponseDTO>> findByName(@PathVariable String name) {
        return ResponseEntity.ok(courseService.findByName(name));
    }

    @Operation(
            summary = "Actualizar un curso",
            description = "Actualiza la información de un curso específico utilizando su ID y los datos proporcionados."
    )
    @ApiResponse(responseCode = "200", description = "Curso actualizado correctamente")
    @ApiResponse(responseCode = "400", description = "Error de validación en los datos proporcionados")
    @ApiResponse(responseCode = "401", description = "No autenticado. Se requiere autenticación")
    @ApiResponse(responseCode = "404", description = "Curso no encontrado o ID no proporcionado")
    @PutMapping("/{id}")
    public ResponseEntity<CourseResponseDTO> update(@PathVariable Long id,
                                                    @Valid @RequestBody CourseRequestDTO request) {
        return ResponseEntity.ok(courseService.update(id, request));
    }

    @Operation(
            summary = "Eliminar un curso",
            description = "Elimina un curso especificado por su ID."
    )
    @ApiResponse(responseCode = "204", description = "Curso eliminado correctamente")
    @ApiResponse(responseCode = "401", description = "No autenticado. Se requiere autenticación")
    @ApiResponse(responseCode = "404", description = "Curso no encontrado o ID no proporcionado")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        courseService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
