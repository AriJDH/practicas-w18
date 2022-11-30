package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Getter @Setter @Data
public class StudentDTO {

    @NotNull(message = "El nombre del estudiante no puede ser null" )
    @NotBlank(message = "El nombre del estudiante no puede estar en blanco" )
    @Size(max = 50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres.")
    String studentName;


    String message;
    Double averageScore;


    List<@Valid SubjectDTO> subjects;
}
