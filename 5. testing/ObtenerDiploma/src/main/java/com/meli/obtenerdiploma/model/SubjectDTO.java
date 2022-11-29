package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la asignatura no debe estar vacio")
    @Pattern(regexp = "[A-Z]\\w*", message = "El nombre de la asignatura debe empezar con mayuscula")
    @Size(max = 30)
    String name;
    @NotEmpty(message = "Score no puede estar vacio")
            @Min(0)
            @Max(10)
    Double score;
}
