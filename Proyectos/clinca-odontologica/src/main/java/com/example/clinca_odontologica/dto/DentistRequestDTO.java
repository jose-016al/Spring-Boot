package com.example.clinca_odontologica.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DentistRequestDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50, message = "El nombre no puede superar los 50 caracteres")
    private String firstName;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50, message = "El apellido no puede superar los 50 caracteres")
    private String lastName;

    @NotBlank(message = "El número de matrícula es obligatorio")
    @Size(max = 20, message = "El número de matrícula no puede superar los 20 caracteres")
    private String licenseNumber;
}
