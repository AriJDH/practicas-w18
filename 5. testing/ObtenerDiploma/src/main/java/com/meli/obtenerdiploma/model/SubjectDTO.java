package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotNull
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")
    @Pattern(regexp = "([A-Z]|Á|É|Í|Ó|Í|Ú)+([a-z]|á|é|í|ó|ú)*", message = "El nombre del alumno debe comenzar con mayúscula.")
    @Size(max=30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message = "La nota no puede estar vacía.")
    @Min(value = 0,message = "La mínima nota es 0.0.")
    @Max(value = 10, message = "La máxima nota es 10.0.")
    Double score;
}
