package com.example.multicapavivo.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonaDTO {
    private String nombre;
    private String apellido;
    private int edad;
}
