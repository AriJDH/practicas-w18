package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotEmpty(message = "El campo name no puede ser vacio")
    @Size(min = 0, max = 30, message = "La longitud maxima permitida es de 30 caracteres")
    @Pattern(regexp = "(^[A-Z])(\\w||\\s)*", message = "El nombre debe comenzar en mayuscula")
    String name;
    @Min(value = 0, message = "El valor minimo es de 0.0 ")
    @Max(value =  10, message = "El valor no puede ser mayor a 10.0")
    @NotNull(message = "El campo score no puede ser vacio")
    Double score;
}
