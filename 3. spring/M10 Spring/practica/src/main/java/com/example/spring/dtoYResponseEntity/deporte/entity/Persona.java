package com.example.spring.dtoYResponseEntity.deporte.entity;

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
    private String apellido;
    private Integer edad;
    private ArrayList<Deporte> deportesFrecuente;
}
