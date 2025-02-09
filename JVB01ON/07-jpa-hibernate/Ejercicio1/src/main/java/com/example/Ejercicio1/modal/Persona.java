package com.example.Ejercicio1.modal;

import jakarta.persistence.*;
import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String name;

    @Column(name = "apellido", nullable = false, length = 50)
    private String surname;

    @Column(name = "edad", nullable = false)
    private int age;
}
