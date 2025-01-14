package com.hackaboss.holaMundo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaMundoController {

    @GetMapping
    public String saludo () {
        return "Hola Mundo desde Spring Boot, soy Jose";
    }

}