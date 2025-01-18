package com.example.Ejercicio2.model;

public class Alumno {

    private Long id;
    private String nombre;
    private String apellido;
    private String numeroMatricula;
    private double notaFinal;
    private String nivelEducativo;

    public Alumno(Long id, String nombre, String apellido, String numeroMatricula, double notaFinal, String nivelEducativo) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroMatricula = numeroMatricula;
        this.notaFinal = notaFinal;
        this.nivelEducativo = nivelEducativo;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public double getNotaFinal() {
        return notaFinal;
    }

    public String getNivelEducativo() {
        return nivelEducativo;
    }
}