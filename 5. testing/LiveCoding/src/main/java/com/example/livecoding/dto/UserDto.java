package com.example.livecoding.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private String nombre;
    @Size(max = 15, message = "no puede tener mas de 15 letras")
    @NotBlank(message = "No puede estar vacio")
    private String apellido;
    @Max(value =  99, message = "No puede tener mas de 99 años.")
    private int edad;
}
