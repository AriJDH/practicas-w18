package com.deportista.clase2.entity;

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
}
