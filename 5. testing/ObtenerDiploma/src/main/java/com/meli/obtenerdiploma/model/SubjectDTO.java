package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {

    @NotNull @NotBlank
    String name;

    @PositiveOrZero
    @NotNull(message = "La nota de la materia no puede estar vacía.")
    @DecimalMax(value = "10.0", message = "La nota máxima de la materia es de 10 pts.")
    @DecimalMin(value = "0.0", message = "La nota mínima de la materia es de 0 pts.")
    Double score;
}
