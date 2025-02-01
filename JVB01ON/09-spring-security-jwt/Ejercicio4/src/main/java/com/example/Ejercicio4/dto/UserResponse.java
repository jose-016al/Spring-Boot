package com.example.Ejercicio4.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
public class UserResponse {
    private String email;
    private String name;
    private String surname;
}
