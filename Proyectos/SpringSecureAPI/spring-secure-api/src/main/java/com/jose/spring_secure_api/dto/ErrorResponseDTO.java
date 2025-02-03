package com.jose.spring_secure_api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponseDTO {
    private String message;
    private int status;
}
