package com.example.deportes.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Persona {
    private Long dni;
    private String nombre;
    private String apellido;
    private List<Integer> deportes = new ArrayList<>();

    public Long getDni(){
        return  dni;
    }
}
