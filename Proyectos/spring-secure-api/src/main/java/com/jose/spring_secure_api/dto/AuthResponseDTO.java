package com.jose.spring_secure_api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Builder
public class AuthResponseDTO {
    private String jwt;
}
