package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull(message = "El nombre de la materia no puede estar vacio")
    @NotBlank(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp = "[A-Z].+", message = "El nombre de la materia debe comenzar con mayuscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;
    @NotNull(message = "La nota no puede estar vacia")
    @Min(value = 0, message = "La minima nota es 0.0")
    @Max(value = 10, message = "La minima nota es 10.0")
    Double score;
}
