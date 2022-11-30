package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.constants.Errors;
import com.meli.obtenerdiploma.constants.Regex;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter
@Setter
public class SubjectDTO {
    @NotNull
    @NotBlank(message = Errors.EMPTY_NAME_SUB)
    @Pattern(regexp = Regex.NAME_PATTERN, message = Errors.SUB_NAME_ERR)
    @Size(max = 30, message = Errors.SUB_NAME_SIZE_ERR)
    String name;
    @NotNull(message = Errors.SUB_SCORE_NULL)
    @Min(value = 0, message = Errors.SUB_SCORE_MIN_ERR)
    @Max(value = 10, message = Errors.SUB_SCORE_MAX_ERR)
    Double score;
}
