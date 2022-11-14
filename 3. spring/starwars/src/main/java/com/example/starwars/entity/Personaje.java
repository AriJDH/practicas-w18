package com.example.starwars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Personaje {

    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public Personaje(String name, Integer height, Integer mass, String hair_color, String skin_color,
                     String eye_color, String birth_year, String gender, String homeworld, String species) {
        this.name = name;
        this.height = height;
        this.mass = mass;
        this.hair_color = hair_color;
        this.skin_color = skin_color;
        this.eye_color = eye_color;
        this.birth_year = birth_year;
        this.gender = gender;
        this.homeworld = homeworld;
        this.species = species;
    }


    public void setHeight(String height) {
        if(height.equals("NA"))
            this.height = null;
        else
            this.height = Integer.valueOf(height);
    }

    public void setMass(String mass) {
        if(mass.equals("NA"))
            this.mass = null;
        else
            this.mass = Integer.valueOf(mass);
    }

}
