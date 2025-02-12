package com.example.clinca_odontologica.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Builder
public class PatientResponseDTO {
    private String firstName;
    private String lastName;
    private String dni;
    private LocalDate admissionDate;
}
