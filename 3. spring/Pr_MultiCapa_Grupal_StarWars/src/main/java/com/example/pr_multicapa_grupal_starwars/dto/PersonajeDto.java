package com.example.pr_multicapa_grupal_starwars.dto;

import com.example.pr_multicapa_grupal_starwars.utilities.IntegerStringDeserialize;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PersonajeDto {
    private String name;
    @JsonDeserialize(using = IntegerStringDeserialize.class)
    private Integer height;
    @JsonDeserialize(using = IntegerStringDeserialize.class)
    private Integer mass;
    @JsonIgnore
    private String hair_color;
    @JsonIgnore
    private String skin_color;
    @JsonIgnore
    private String eye_color;
    @JsonIgnore
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;
}
