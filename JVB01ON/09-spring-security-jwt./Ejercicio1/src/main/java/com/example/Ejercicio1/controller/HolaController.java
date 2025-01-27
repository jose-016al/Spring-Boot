package com.example.Ejercicio1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pruebasecurity")
public class HolaController {

    @GetMapping("/holaseq")
    public String holaMundoSeguro() {
        return "Hola mundo con seguridad";
    }

    @GetMapping("/holanoseq")
    public String holaMundoNoSeguro() {
        return "Hola mundo sin seguridad";
    }
}
