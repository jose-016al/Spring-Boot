package com.jose.spring_secure_api.controller;

import com.jose.spring_secure_api.dto.AuthRequestDTO;
import com.jose.spring_secure_api.dto.AuthResponseDTO;
import com.jose.spring_secure_api.dto.RegisterRequestDTO;
import com.jose.spring_secure_api.service.IAuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Autenticación")
public class AuthController {

    private final IAuthService authService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "El inicio de sesión fue exitoso."),
            @ApiResponse(responseCode = "401", description = "Las credenciales proporcionadas son incorrectas."),
            @ApiResponse(responseCode = "400", description = "Los datos enviados no son válidos. Verifica los campos.")
    })
    @Operation(summary = "Método para realizar el inicio de sesión, devolviendo un JWT si las credenciales son correctas.")
    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody @Valid AuthRequestDTO request) {
        return ResponseEntity.ok(authService.login(request));
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "El usuario ha sido registrado exitosamente."),
            @ApiResponse(responseCode = "409", description = "Ya existe un usuario con el mismo nombre o correo."),
            @ApiResponse(responseCode = "400", description = "Los datos enviados no son válidos. Verifica los campos.")
    })
    @Operation(summary = "Método para registrar un nuevo usuario en la aplicación.")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody @Valid RegisterRequestDTO request) {
        authService.register(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado correctamente");
    }
}
