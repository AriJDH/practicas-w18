package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter
@Setter
public class StudentDTO {

    @NotEmpty(message = "Student name may not be empty")
    @Size(max = 50, message = "Student name cannot be longer than 50 characters")
    @Pattern(regexp = "(^[A-Z])(\\w||\\s)*", message = "The student name must have the following format: Capital letter + lower case")
    String studentName;

    String message;
    Double averageScore;

    @Valid
    @NotEmpty(message = "Subjects list may not empty")
    List<SubjectDTO> subjects;
}
