package com.example.StarWars.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personality {
    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

    public Integer getHeight() {
        try{
            return Integer.valueOf(this.height);
        } catch (NumberFormatException e){
            return null;
        }
    }

    public Integer getMass() {
        try{
            return Integer.valueOf(this.mass);
        } catch (NumberFormatException e){
            return null;
        }
    }
}
