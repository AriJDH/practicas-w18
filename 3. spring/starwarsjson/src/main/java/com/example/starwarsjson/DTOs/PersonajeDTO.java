package com.example.starwarsjson.DTOs;

import com.example.starwarsjson.entities.Personaje;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PersonajeDTO {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;

    public PersonajeDTO(Personaje personaje){
        this.name = personaje.getName();
        this.height = personaje.getHeight();
        this.mass= personaje.getMass();
        this.gender=personaje.getGender();
        this.homeworld=personaje.getHomeworld();
        this.species=personaje.getSpecies();
    }
}
