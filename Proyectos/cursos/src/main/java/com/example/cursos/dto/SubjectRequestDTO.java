package com.example.cursos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SubjectRequestDTO {

    @NotBlank(message = "El nombre del tema no puede estar vacío")
    private String name;

    private String description;

    @NotNull(message = "Debes especificar un curso")
    private Long courseId;
}
