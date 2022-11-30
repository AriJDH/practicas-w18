package com.example.Deportista.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {

    String nombre;
    String apellido;
    int edad;
    String deporteRealizado;

}
