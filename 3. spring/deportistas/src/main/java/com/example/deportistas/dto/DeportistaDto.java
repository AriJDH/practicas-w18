package com.example.deportistas.dto;

import com.example.deportistas.entities.Deporte;
import com.example.deportistas.entities.Persona;

import java.util.List;

public class DeportistaDto {
    private Persona persona;
    private List<Deporte> deportes;

    public DeportistaDto(Persona persona, List<Deporte> deportes) {
        this.persona = persona;
        this.deportes = deportes;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Deporte> getDeportes() {
        return deportes;
    }

    public void setDeportes(List<Deporte> deportes) {
        this.deportes = deportes;
    }

    @Override
    public String toString() {
        return "DeportistaDto{" +
                "persona=" + persona +
                ", deportes=" + deportes +
                '}';
    }
}
