package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Size(min = 1, max = 50, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp = "([A-Z][a-z']*)", message = "El nombre del alumno debe comenzar con mayúscula.")
    private String studentName;

    private String message;

    private Double averageScore;

    @Valid
    @NotEmpty(message = "La lista no puede ser vacia.")
    private List<SubjectDTO> subjects;
}
