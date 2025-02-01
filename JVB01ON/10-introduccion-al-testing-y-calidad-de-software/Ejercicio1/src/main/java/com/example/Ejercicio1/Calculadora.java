package com.example.Ejercicio1;

public class Calculadora {
    public Double calcularSuma (int num1, int num2) {
        return (double) num1+num2;
    }

    public Double calcularMenor (int num1, int num2) {
        if (num1<=num2) {
            return (double) num1;
        }
        else {
            return (double) num2;
        }
    }
}