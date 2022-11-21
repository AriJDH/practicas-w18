package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotEmpty(message = "El campo no puede ser nulo")
    @Size(max = 30, message = "El campo no puede tener mas de 30 caracteres")
    String name;
    @NotNull(message = "El campo no puede ser nulo")
    @Min(0) @Max(10)
    Double score;
}
