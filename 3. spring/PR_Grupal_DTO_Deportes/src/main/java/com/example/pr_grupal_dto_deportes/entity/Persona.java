package com.example.pr_grupal_dto_deportes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Persona {
    private String name;
    private String lastName;
    private int edad;
    private ArrayList<Deporte> deportesFrecuentes;

    public boolean esDeportista(){
        int cantDeportes = deportesFrecuentes!=null? deportesFrecuentes.size() : 0;
        return (cantDeportes>0);
    }
}
