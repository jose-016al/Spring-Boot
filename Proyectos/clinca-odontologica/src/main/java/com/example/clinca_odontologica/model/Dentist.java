package com.example.clinca_odontologica.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "dentistas")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String firstName;

    @Column(name = "apellidos", nullable = false)
    private String lastName;

    @Column(name = "numero_matricula")
    private String licenseNumber;

    @OneToMany(mappedBy = "dentist", orphanRemoval = true)
    private List<Appointment> appointments = new ArrayList<>();
}
