package com.jose.spring_secure_api.controller;

import com.jose.spring_secure_api.dto.UserResponseDTO;
import com.jose.spring_secure_api.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
@Tag(name = "Usuarios")
public class UserController {

    private final IUserService userService;

    @Operation(summary = "Obtiene todos los usuarios", description = "Este método devuelve una lista de todos los usuarios registrados en el sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuarios encontrados correctamente"),
            @ApiResponse(responseCode = "403", description = "Acceso denegado. No tiene permisos para añadir productos o el token es inválido."),
            @ApiResponse(responseCode = "401", description = "Token inválido o expirado."),
    })
    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Usuario autenticado encontrado correctamente"),
            @ApiResponse(responseCode = "403", description = "El usuario no está autenticado. Token faltante."),
            @ApiResponse(responseCode = "401", description = "Token inválido o expirado."),
    })
    @Operation(summary = "Obtiene los detalles del usuario autenticado", description = "Este método devuelve los detalles del usuario que ha iniciado sesión en el sistema.")
    @GetMapping("/me")
    public ResponseEntity<UserResponseDTO> findMyUser() {
        return ResponseEntity.ok(userService.findMyUser());
    }
}
