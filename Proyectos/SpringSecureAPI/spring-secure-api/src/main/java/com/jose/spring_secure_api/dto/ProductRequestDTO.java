package com.jose.spring_secure_api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Builder
public class ProductRequestDTO {

    @NotBlank(message = "El nombre no puede estar vacío.")
    private String name;

    @DecimalMin(value = "0.01", message = "El precio debe ser mayor que 0.")
    private double price;
}
