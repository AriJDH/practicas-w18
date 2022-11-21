package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
    @NotEmpty(message = "El campo no puede ser nulo")
    @Size(max=50, message = "El campo no puede tener mas de 50 caracteres")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty
    List<SubjectDTO> subjects;
}
