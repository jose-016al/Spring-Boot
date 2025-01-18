package com.example.Ejercicio4.controller;

import com.example.Ejercicio4.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    List<Cliente> clientes = Arrays.asList(
            new Cliente(1L, "Juan", "juan@gmail.com"),
            new Cliente(2L, "María", "maria@hotmail.com"),
            new Cliente(3L, "Carlos", "carlos@yahoo.com")
    );

    @GetMapping("/clientes")
    public List<Cliente> obtenerTodos() {
        return clientes;
    }
}