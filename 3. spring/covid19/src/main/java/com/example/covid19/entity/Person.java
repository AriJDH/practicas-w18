package com.example.covid19.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Person {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Symptom> symptoms;
}
