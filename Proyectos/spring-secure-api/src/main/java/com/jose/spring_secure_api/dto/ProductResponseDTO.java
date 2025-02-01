package com.jose.spring_secure_api.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@Builder
public class ProductResponseDTO {
    private String name;
    private double price;
}
