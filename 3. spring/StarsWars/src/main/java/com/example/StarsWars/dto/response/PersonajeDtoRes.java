package com.example.StarsWars.dto.response;

import com.example.StarsWars.entity.Personaje;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class PersonajeDtoRes {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;


    //Constructor que recive un perosnaje para poder mapear mas facil;
    public PersonajeDtoRes (Personaje p){
        this.name = p.getName();
        this.height = p.getHeight();
        this.mass = p.getMass();
        this.gender = p.getGender();
        this.homeworld = p.getHomeworld();
        this.species = p.getSpecies();
    }
}
