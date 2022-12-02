package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class StudentDTO {

    @NotBlank(message = "El nombre del Alumno no puede estar vacío")
    @Pattern(regexp = "([A-Z]|Á|É|Í|Ó|Ú)+([a-z]|á|é|í|ó|ú)*", message = "El nombre del Alumno debe comenzar con mayúscula")
    @Size(max = 50, message = "La Longuitud del nombre no puede superar los 50 caracteres")
    String studentName;
    String message;
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<@Valid SubjectDTO> subjects;

}
