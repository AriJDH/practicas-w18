package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;

@Valid
@Getter @Setter
public class StudentDTO {

    @NotEmpty(message = "El nombre del alumno no puede ser vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max=50, message = "La longitud del nombre no puede superar los 50 caracteres")
    String studentName;

    String message;
    Double averageScore;
    List<@NotBlank(message = "La lista no puede ser vacía.") SubjectDTO> subjects;
}
