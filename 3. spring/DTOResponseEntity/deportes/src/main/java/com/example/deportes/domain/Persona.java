package com.example.deportes.domain;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private int edad;

}
