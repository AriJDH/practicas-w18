package com.example.multicapa.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PersonaDto {
    private String nombre;
    private String apellido;
    private int edad;
}
