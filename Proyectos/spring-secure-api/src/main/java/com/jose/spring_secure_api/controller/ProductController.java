package com.jose.spring_secure_api.controller;

import com.jose.spring_secure_api.dto.ProductRequestDTO;
import com.jose.spring_secure_api.dto.ProductResponseDTO;
import com.jose.spring_secure_api.model.Product;
import com.jose.spring_secure_api.repository.ProductRepository;
import com.jose.spring_secure_api.service.IProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
@Tag(name = "Productos")
public class ProductController {

    private final IProductService productService;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Productos obtenidos correctamente."),
            @ApiResponse(responseCode = "403", description = "El usuario no está autenticado. Token faltante."),
            @ApiResponse(responseCode = "401", description = "Token inválido o expirado."),
    })
    @Operation(summary = "Obtener la lista de todos los productos")
    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Producto añadido correctamente."),
            @ApiResponse(responseCode = "400", description = "Error de validación en los campos."),
            @ApiResponse(responseCode = "403", description = "Acceso denegado. No tiene permisos para añadir productos o el token es inválido."),
            @ApiResponse(responseCode = "401", description = "Token inválido o expirado."),
    })
    @Operation(summary = "Añadir un nuevo producto")
    @PostMapping
    public ResponseEntity<String> save(@RequestBody @Valid ProductRequestDTO request) {
        productService.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("Producto añadido");
    }
}
