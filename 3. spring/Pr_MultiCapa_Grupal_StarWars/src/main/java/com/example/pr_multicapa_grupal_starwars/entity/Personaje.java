package com.example.pr_multicapa_grupal_starwars.entity;

import com.example.pr_multicapa_grupal_starwars.utilities.IntegerStringDeserialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {
    private String name;
    @JsonDeserialize(using = IntegerStringDeserialize.class)
    private Integer height;
    @JsonDeserialize(using = IntegerStringDeserialize.class)
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
}
