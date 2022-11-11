package com.kotor.starwars.entity;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {
    private String name;
    private String height;
    private String mass;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("birth_year")
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

    public int getHeight() {
        if (height.equals("NA")) {
            return -1;
        }
        return Integer.parseInt(height.replaceAll("[^a-zA-Z0-9]", ""));
    }

    public int getMass() {
        if (height.equals("NA")) {
            return -1;
        }
        return Integer.parseInt(mass.replaceAll("[^a-zA-Z0-9]", ""));
    }
}
