package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacio")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")//@Pattern(regexp = "^[a-z ,.'-]+$", message = "El nombre debe empezar con mayúscula")
    @Size(max = 30,message = "La longitud del nombre no puede superar los 30 caracteres")
    String name;

    @NotNull(message = "La nota no puede estar vacia")
    @DecimalMax(value="10.0", message = "La nota no puede ser mayor a 10")
    @DecimalMin(value="0.0", message = "la nota no puede ser menor a 0")
    Double score;
}
