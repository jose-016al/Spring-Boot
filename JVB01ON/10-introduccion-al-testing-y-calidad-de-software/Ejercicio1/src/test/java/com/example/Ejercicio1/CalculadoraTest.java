package com.example.Ejercicio1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculadoraTest {

    @Test
    public void testCalcularSuma() {
        Calculadora calculadora = new Calculadora();
        Double resultado = calculadora.calcularSuma(3, 5);
        assertEquals(8.0, resultado); // Verifica que la suma sea correcta (3 + 5 = 8)
    }

    @Test
    public void testCalcularSumaMayor() {
        Calculadora calculadora = new Calculadora();
        int num1 = 5;
        int num2 = 3;
        Double resultado = calculadora.calcularSuma(num1, num2);
        assertEquals(8.0, resultado); // Verifica que la suma sea correcta (5 + 3 = 8)
    }

    @Test
    public void testCalcularSumaMenor() {
        Calculadora calculadora = new Calculadora();
        int num1 = 3;
        int num2 = 5;
        Double resultado = calculadora.calcularSuma(num1, num2);
        assertEquals(8.0, resultado); // Verifica que la suma sea correcta (3 + 5 = 8)
    }
}

