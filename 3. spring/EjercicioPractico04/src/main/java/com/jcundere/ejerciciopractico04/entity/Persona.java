package com.jcundere.ejerciciopractico04.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Deporte> deportesPracticados = new ArrayList<>();

    public Persona(String nombre, String apellido, Integer edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public void agregaDeporta(Deporte deporte) {
        deportesPracticados.add(deporte);
    }

}
