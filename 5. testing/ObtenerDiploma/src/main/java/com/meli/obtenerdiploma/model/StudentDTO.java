package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede estar vacio")
    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    @Pattern(regexp = "[A-Z].+", message = "El nombre del alumno debe comenzar con mayuscula")
    @Size(max = 50, message = "La loongitud del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotNull(message = "La lista no puede ser vacia")
    @NotEmpty(message = "La lista no puede ser vacia")
    List<@Valid SubjectDTO> subjects;
}
