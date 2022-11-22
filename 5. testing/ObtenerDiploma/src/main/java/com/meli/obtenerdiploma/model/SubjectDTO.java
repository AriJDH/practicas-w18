package com.meli.obtenerdiploma.model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(
      regexp = "[A-Z]\\w*",
      message = "El nombre de la materia debe comenzar con mayúscula."
    )
    @Size(
      min = 3,
      max = 30,
      message = "La longitud de la materia no puede superar los 30 caracteres"
    )
  String name;

  @NotNull(message = "La nota no puede estar vacía.")
  @DecimalMin(value = "0.0", message = "La mínima nota es 0.0.")
  @DecimalMax(value = "10.0", message = "La máxima nota es 10.0.")
  Double score;
}
