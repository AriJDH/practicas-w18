package com.example.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Symptom {
    private String codigo;
    private String nombre;
    private int nivel_de_gravedad;
}
