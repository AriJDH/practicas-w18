package com.example.covid.domain;

import com.example.covid.domain.dtos.PersonaDTO;
import com.example.covid.domain.dtos.SintomaDTO;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public @Data class Persona {
    private long id;
    private String nombre;
    private String apellido;
    private int edad;
    private List<Sintoma> sintomas = new ArrayList<>();

    public Persona(long id, String nombre, String apellido, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    public PersonaDTO toDTO(){
        return new PersonaDTO(this.nombre,this.apellido,this.edad);
    }

    public void addSintoma(Sintoma sintoma){
        this.sintomas.add(sintoma);
    }
}
