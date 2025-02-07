package com.example.cursos.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder
public class CourseRequestDTO {

    @NotBlank(message = "El nombre del curso no puede estar vacío")
    private String name;

    @NotBlank(message = "El tipo de curso no puede estar vacío")
    private String type;

    @NotNull(message = "La fecha de finalización no puede estar vacía")
    @FutureOrPresent(message = "La fecha de finalización debe estar en el futuro o en el presente")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;
}
