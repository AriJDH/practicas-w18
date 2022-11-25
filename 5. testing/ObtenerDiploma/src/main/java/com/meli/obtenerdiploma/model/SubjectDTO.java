package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.\n" )
    @Pattern(regexp = "([A-Z][a-z]*$)",message = "El nombre de la materia debe comenzar con mayúscula.\n")
    @Size(max = 30,message = "La longitud del nombre no puede superar los 30 caracteres.\n")
    String name;
    @NotNull(message = "La nota no puede estar vacía.\n" )
    @DecimalMin(value = "0.0",message = "La mínima nota es 0.0.")
    @DecimalMax(value = "10.0",message = "La máxima nota es 10.0." )
    Double score;
}
