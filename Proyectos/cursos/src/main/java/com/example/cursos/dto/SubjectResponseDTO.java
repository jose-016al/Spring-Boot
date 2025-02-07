package com.example.cursos.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class SubjectResponseDTO {
    private String name;
    private String description;
}
