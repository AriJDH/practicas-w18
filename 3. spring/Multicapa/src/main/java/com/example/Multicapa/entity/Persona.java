package com.example.Multicapa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@AllArgsConstructor
@NonNull
@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
}
