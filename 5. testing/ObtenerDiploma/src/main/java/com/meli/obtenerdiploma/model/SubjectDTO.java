package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank
    @NotNull(message = "El nombre de la materia no puede estar vacío")
    @Pattern(regexp = "[A-Z]\\w*", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(min=0,max = 50, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;

    @NotNull(message = "La nota no puede estar vacía")
    @Max(value = 10,message = "La máxima nota es 10.0")
    @Min(value = 0, message = "La mínima nota es 0.0")
    @NotBlank(message = "La nota no puede estar vacía")
    Double score;
}
