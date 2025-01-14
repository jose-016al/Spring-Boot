package com.example.Ejercicio4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ProveedorController {

    List<Proveedor> proveedores = Arrays.asList(
            new Proveedor(1L, "Juan", "Gerente"),
            new Proveedor(2L, "María", "Vendedora"),
            new Proveedor(3L, "Carlos", "Distribuidor")
    );

    @GetMapping("/proveedores")
    public List<Proveedor> obtenerTodos() {
        return proveedores;
    }
}
