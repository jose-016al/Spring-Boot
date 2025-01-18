package com.example.Ejercicio3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class MaquinaController {

    @GetMapping("/sorteo1")
    public String sorteo1() {
        int randomNumber = (int) (Math.random() * 100) + 1;
        return "El resultado del sorteo es: " + randomNumber;
    }

    @GetMapping("/sorteo2")
    public String sorteo2() {
        List<Integer> listNumbers = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            listNumbers.add((int) (Math.random() * 100) + 1);
        }

        String result = "Los números sorteados han sido: [" +
                listNumbers.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                "]";
        return result;
    }
}