package com.example.Ejercicio3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RomanoController {

    @GetMapping("/convertir")
    public String convertirDecimalARomano(@RequestParam int numero) {
        int[] valores = {1000, 100, 50, 10, 5, 1};
        String[] simbolos = {"M", "C", "L", "X", "V", "I"};

        String resultado = "";
        for (int i = 0; i < valores.length; i++) {
            while (numero >= valores[i]) {
                numero -= valores[i];
                resultado += simbolos[i];
            }
        }

        return "El valor romano del numero es: " + resultado;
    }

}