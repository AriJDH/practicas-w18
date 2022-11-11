package com.ejerciciospring.ejercicios_spring.practica_arquitectura_multicapa_p1_vivo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.*;

@Data
public class Personaje {

    private String name;

    @JsonDeserialize(using = IntegerStringDeserialize.class)
    private Integer height;

    @JsonDeserialize(using = IntegerStringDeserialize.class)
    private Integer mass;

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
