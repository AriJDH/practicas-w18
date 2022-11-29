package com.meli.obtenerdiploma.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.intellij.lang.annotations.RegExp;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter @Data
public class StudentDTO {
    @NotEmpty(message = "Nombre no puede estar vacio")
    @Size(max=50)
    @Pattern(regexp = "[A-Z]\\w*",message = "El nombre debe empezar con mayuscula")
    private String studentName;

    String message;
    Double averageScore;
    @Valid
    List<SubjectDTO> subjects;
}
