package com.jose.spring_secure_api.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDTO {
    private String username;
    private String name;
}
