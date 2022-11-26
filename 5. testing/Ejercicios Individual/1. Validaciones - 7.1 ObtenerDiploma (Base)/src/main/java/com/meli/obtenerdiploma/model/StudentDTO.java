package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class StudentDTO {
	
	@NotBlank(message = "El nombre del alumno no puede estar vacío")
	@Pattern(regexp = "^[A-Z]+\\w*",
	         message = "El nombre del alumno debe empezar con mayúscula")
	@Size(min = 1,
	      max = 50,
	      message = "La longitud del nombre no puede superar los 50 caracteres")
	String studentName;
	String message;
	Double averageScore;
	@Valid
	@NotEmpty(message = "La lista no puede estar vacía")
	List<SubjectDTO> subjects;
}
