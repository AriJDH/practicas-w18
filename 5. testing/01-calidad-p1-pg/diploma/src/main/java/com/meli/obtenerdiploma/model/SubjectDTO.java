package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula.")
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
    String name;
    @NotNull(message = "La nota no puede estar vacía.")
    @Range(min=0, max=10, message = "La mínima nota es 0.0. La máxima nota es 10.0.")
    Double score;
}
