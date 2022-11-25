package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;


import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El nombre del alumno no puede estar vacío.\n")
    @Pattern(regexp = "([A-Z][a-z]*$)",message = "El nombre del alumno debe comenzar con mayúscula.\n")
    @Size(max = 50,message = "La longitud del nombre no puede superar los 50 caracteres.\n")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede ser vacía.\n")
    List<@Valid SubjectDTO> subjects;
}
