package com.example.clinca_odontologica.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@Builder
public class AppointmentResponseDTO {
    private Long patient;
    private Long dentist;
    private LocalDate appointmentDate;
}
