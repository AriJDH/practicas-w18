package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.util.CapitalizeStringConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {

    @NotBlank(message = "El nombre del alumno no puede estar vacío")
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @CapitalizeStringConstraint(message = "El nombre del alumno debe comenzar con mayúsculas")
    String studentName;

    String message;

    @Min(value=0, message = "Average score value must be greater or equal to zero.")
    @Max(value=10, message = "Average score must be less or equal to ten")
    Double averageScore;

    @Valid
    @NotEmpty(message = "Subjects list cannot be empty.")
    List<SubjectDTO> subjects;
}

// JSON REPRESENTATION
// {
//  "studentName": "",
//  "message": "",
//  "averageScore": 0.0,
//  "subjects": [
//    {
//      "name": "",
//      "score": 0.0
//    }
//  ]
//}