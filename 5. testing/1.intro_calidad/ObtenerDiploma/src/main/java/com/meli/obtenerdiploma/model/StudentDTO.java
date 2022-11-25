package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotBlank(message = "the student name cannot be empty")
    @Size(max = 50, message = "the student name length cannot be >50")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The student's name must start with upper case")
    String studentName;

    String message;
    Double averageScore;
    @NotEmpty(message = "the list of subjects cannot be empty")
    List<SubjectDTO> subjects;
}
