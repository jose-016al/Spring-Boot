package com.example.Ejercicio1;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductoController {

    @PostMapping("/productos")
    public String crearProducto(@RequestBody Producto nuevoProducto) {
        // Realizar alguna lógica con el nuevo producto, como guardarlo en una base de datos
        // nuevoProducto contiene los datos enviados desde el cliente en formato JSON

        return "Producto creado: " + nuevoProducto.getNombre();
    }

}