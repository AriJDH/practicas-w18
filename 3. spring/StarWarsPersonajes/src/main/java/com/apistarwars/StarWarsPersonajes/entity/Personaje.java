package com.apistarwars.StarWarsPersonajes.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor


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
}
