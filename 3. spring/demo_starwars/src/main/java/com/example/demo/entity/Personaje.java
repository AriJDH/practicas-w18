package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {
    private String name;
    private String height;
    private String mass;
    private @JsonProperty("hair_color") String hairColor;
    private @JsonProperty("skin_color") String skinColor;
    private @JsonProperty("eye_color")  String eyeColor;
    private @JsonProperty("birth_year") String birthYear;
    private String gender;
    private String homeworld;
    private String species;

}
