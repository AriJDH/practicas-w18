package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotEmpty(message = "Subject name may not be empty")
    @Size(max = 30, message = "Subject name cannot be longer than 30 characters")
    @Pattern(regexp = "(^[A-Z])(\\w||\\s)*", message = "The subject name must have the following format: Capital letter + lower case")
    String name;
    @NotNull(message = "Score may not be null")
    @Min(value = 0, message = "Score minimum 0.0")
    @Max(value = 10, message = "Score maximum 10.0.")
    Double score;
}
