package com.example.StarsWars.entity;

import com.example.StarsWars.deserializers.IntegerDeserilizerCustom;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

public class Personaje {
    private String name;
    @JsonDeserialize(using = IntegerDeserilizerCustom.class)
    private Integer height;
    @JsonDeserialize(using = IntegerDeserilizerCustom.class)
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
}

