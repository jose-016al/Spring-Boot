package com.example.clinca_odontologica.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class AppointmentRequestDTO {

    @NotNull(message = "El ID del paciente es obligatorio")
    private Long patientId;

    @NotNull(message = "El ID del dentista es obligatorio")
    private Long dentistId;

    @NotNull(message = "La fecha del turno es obligatoria")
    @FutureOrPresent(message = "La fecha del turno no puede estar en el pasado")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate appointmentDate;
}
