package com.example.starwarsjson.entities;

import com.example.starwarsjson.deserializers.IntegerStringDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
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
