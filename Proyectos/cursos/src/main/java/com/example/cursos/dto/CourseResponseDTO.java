package com.example.cursos.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CourseResponseDTO {
    private String name;
    private String type;
    private LocalDate endDate;
}
