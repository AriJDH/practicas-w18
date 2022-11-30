package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.constants.Errors;
import com.meli.obtenerdiploma.constants.Regex;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull
    @NotBlank(message = Errors.EMPTY_NAME_STU)
    @Pattern(regexp = Regex.NAME_PATTERN, message = Errors.STU_NAME_ERR)
    @Size(max=50, message = Errors.STU_NAME_SIZE_ERR)
    String studentName;
    String message;
    Double averageScore;

    @NotNull
    @NotEmpty(message = Errors.EMPTY_LIST)
    List<@Valid SubjectDTO> subjects;
}
