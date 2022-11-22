package com.meli.obtenerdiploma.model;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTO {
  @NotNull(message = "El nombre del alumno no puede estar vacío..")
  @Pattern(
    regexp = "[A-Z]\\w*",
    message = "El nombre del alumno debe comenzar con mayúscula."
  )
  @Size(
    min = 3,
    max = 50,
    message = "La longitud del nombre no puede superar los 50 caracteres."
  )
  String studentName;
  String message;
  Double averageScore;
  @NotEmpty(message = "La lista no puede ser vacía.")
  List< 
  @Valid
  SubjectDTO
  
  > subjects;
}
