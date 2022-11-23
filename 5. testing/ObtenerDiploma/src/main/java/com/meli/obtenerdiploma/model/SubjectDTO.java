package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotEmpty(message = "El campo nombre no puede ser vacio")
    @Size(min = 0, max = 30, message = "La longitud maxima permitida es de 30 caracteres")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    String name;
    @Min(value = 0, message = "El valor minimo es de 0.0 ")
    @Max(value =  10, message = "El valor no puede ser mayor a 10.0")
    @NotNull(message = "El campo score no puede ser vacio")
    Double score;
}
