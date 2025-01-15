package com.example.Ejercicio2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecibirController {

        // URL: /saludo?nombre=Jose
    @GetMapping("/saludo")
    public String saludarNombre(@RequestParam String nombre) {
        return "Hola mundo, " + nombre;
    }

        // URL: /saludoConEdad?nombre=Jose&edad=25
    @GetMapping("/saludoConEdad")
    public String saludarNombreYEdad(@RequestParam String nombre, @RequestParam int edad) {
        return "Hola mundo, " + nombre + ", " + edad + " años";
    }

        // URL: /saludoCompleto?nombre=Jose&edad=25&profesion=developer
    @GetMapping("/saludoCompleto")
    public String saludarNombreEdadProfesion(@RequestParam String nombre,
                                             @RequestParam int edad,
                                             @RequestParam String profesion) {
        return "Hola mundo, " + nombre + ", " + edad + " años, " + profesion;
    }
}
