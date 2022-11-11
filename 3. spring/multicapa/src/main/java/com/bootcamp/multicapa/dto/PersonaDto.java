package com.bootcamp.multicapa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonaDto {
    private String nombre;
    private String apellido;
    private int edad;
}
