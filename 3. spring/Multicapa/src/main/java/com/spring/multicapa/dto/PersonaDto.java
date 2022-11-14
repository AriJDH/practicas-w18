package com.spring.multicapa.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonaDto {
    private String nombre;
    private String apellido;
    private int edad;
}
