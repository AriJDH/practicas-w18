package com.example.multicapa.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Data

public class Persona {
    private String nombre;
    private String apellido;
    private int edad;

}
