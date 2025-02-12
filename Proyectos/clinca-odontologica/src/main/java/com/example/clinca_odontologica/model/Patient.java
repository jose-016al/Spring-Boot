package com.example.clinca_odontologica.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "pacientes")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String firstName;

    @Column(name = "apellidos", nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String dni;

    @Column(name = "fecha_ingreso")
    private LocalDate admissionDate;

    @OneToMany(mappedBy = "patient", orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();
}
