package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {

    @NotNull(message = "El nombre del alumno no puede estar vacío.")
    @NotEmpty(message = "El nombre del alumno no puede estar vacíooo.")
    @Size(max = 3, message = "La longitud del nombre no puede superar los 50 caracteres.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    String studentName;
    String message;
    Double averageScore;

    @NotEmpty(message = "La lista no puede ser vacía")
    @Valid
    List<SubjectDTO> subjects;
}
