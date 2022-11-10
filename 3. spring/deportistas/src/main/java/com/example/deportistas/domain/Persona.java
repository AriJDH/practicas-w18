package com.example.deportistas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public @Data class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;
}
