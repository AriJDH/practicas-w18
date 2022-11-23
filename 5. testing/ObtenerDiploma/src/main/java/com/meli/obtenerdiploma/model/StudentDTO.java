package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El campo studentName no peude ser vacio")
    @Size(min = 5, max=50 , message = "El valor debe ser menor a 50 caracteres")
    @Pattern(regexp="(^[A-Z])(\\w||\\s)*", message = "El nombre debe comenzar en mayuscula")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    List<@Valid SubjectDTO> subjects;
}
