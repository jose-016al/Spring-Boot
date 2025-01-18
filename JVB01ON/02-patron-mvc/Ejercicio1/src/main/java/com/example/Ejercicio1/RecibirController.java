package com.example.Ejercicio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecibirController {

    // URL: /saludo/{nombre}
    @GetMapping("/saludo/{nombre}")
    public String saludo(@PathVariable String nombre) {
        return "Hola mundo, " + nombre;
    }

    // URL: /saludo/{nombre}/{edad}
    @GetMapping("/saludo/{nombre}/{edad}")
    public String saludo(@PathVariable String nombre, @PathVariable int edad) {
        return "Hola mundo, " + nombre + ", " + edad + " años";
    }

    // URL: /saludo/{nombre}/{edad}/{profesion}
    @GetMapping("/saludo/{nombre}/{edad}/{profesion}")
    public String saludo(@PathVariable String nombre,
                         @PathVariable int edad,
                         @PathVariable String profesion) {
        return "Hola mundo, " + nombre + ", " + edad + " años, " + profesion;
    }
}
