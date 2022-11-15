package com.example.repaso.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@AllArgsConstructor
@NoArgsConstructor
@Data
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
