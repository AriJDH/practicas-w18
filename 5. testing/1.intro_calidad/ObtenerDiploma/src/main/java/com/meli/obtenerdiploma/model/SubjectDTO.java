package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "the name cannot be empty")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "The subject's name must start with upper case")
    @Size(max = 30, message = "the name's length cannot be >30")
    String name;
    @NotNull(message = "the score cannot be empty")
    @DecimalMax(value = "10.0", message = "Max grade is 10.0.")
    @DecimalMin(value = "0.0", message = "Min grade is 0.0.")
    Double score;
}
