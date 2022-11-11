package com.starwars.starwars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personaje {
    String name;
    String height;
    String mass;
    String hair_color;
    String skin_color;
    String eye_color;
    String birth_year;
    String gender;
    String homeworld;
    String species;


    public Integer getHeight() {
        return Integer.valueOf(height);
    }

    public Integer getMass() {
        return Integer.valueOf(mass);
    }
}
