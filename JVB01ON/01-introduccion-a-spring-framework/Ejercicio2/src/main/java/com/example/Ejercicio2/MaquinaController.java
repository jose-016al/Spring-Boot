package com.example.Ejercicio2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaquinaController {

    @GetMapping
    public String realizarSorteo() {
        int randomNumber = (int) (Math.random() * 100) + 1;
        return "El numero sorteado es: " + randomNumber;
    }
}