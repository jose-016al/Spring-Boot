package com.example.clinca_odontologica.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "dentista_id", nullable = false)
    private Dentist dentist;

    @Column(name = "Fecha")
    private LocalDate appointmentDate;
}