package com.example.Ejercicio1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/documentation")
public class MainController {

    @GetMapping("/get")
    public String ejemploGet() {
        return "Prueba get";
    }

    @PostMapping("/post")
    public String ejemploPost() {
        return "Prueba post";
    }
}
