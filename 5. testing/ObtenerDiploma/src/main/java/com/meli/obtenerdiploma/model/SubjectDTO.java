package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Size(min = 1, max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    @Pattern(regexp = "([A-Z-À-ÿ][a-z-ZÀ-ÿ]*)", message = "El nombre de la materia debe comenzar con mayúscula.")
    private String name;

    @NotNull(message = "La nota no puede ser nula.")
    @Min(value = 0, message = "La mínima nota es 0.0.")
    @Max(value = 10, message = "La mínima nota es 10.0.")
    private Double score;
}
