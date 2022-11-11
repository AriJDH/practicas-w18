package com.example.covid19.model;

import jdk.jfr.DataAmount;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Data
@Getter
@Setter
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;

    private ArrayList<Sintoma> sintomas;

    public Persona(int id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
}
