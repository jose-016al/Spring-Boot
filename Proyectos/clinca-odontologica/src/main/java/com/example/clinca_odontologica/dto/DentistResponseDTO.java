package com.example.clinca_odontologica.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class DentistResponseDTO {
    private String firstName;
    private String lastName;
    private String licenseNumber;
}
