package com.example.livecodingtest.dto;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class UserDto {

    private String nombre;
    @Size(max = 15, message = "no puede tener mas de 15 letras")
    @NotBlank(message = "no puede estar vacío.")
    private String apellido;
    @Max(value = 99, message = "No puede tener mas de 99 years.")
    private int edad;

}
