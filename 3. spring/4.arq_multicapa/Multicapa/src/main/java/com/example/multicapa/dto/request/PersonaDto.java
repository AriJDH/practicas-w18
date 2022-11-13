package com.example.multicapa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
//setters esta de mas en dto
public class PersonaDto {
    private String nombre;
    private String apellido;
    private int edad;
}
