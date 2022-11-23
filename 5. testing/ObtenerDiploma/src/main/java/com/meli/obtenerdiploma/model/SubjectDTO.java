package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El campo name no puede ser vacio")
    @Max(value  = 30 , message = "La longitud maxima permitida es de 30 caracteres" )
    @Pattern(regexp="(^[A-Z])(\\w||\\s)*", message = "El nombre debe comenzar en mayuscula")
    String name;
    @NotEmpty(message = "El campo name no puede ser vacio")
@Size(min = 0, max = 10, message = "El valor minimo es de 0.0 y maximo de 10")
    Double score;
}
