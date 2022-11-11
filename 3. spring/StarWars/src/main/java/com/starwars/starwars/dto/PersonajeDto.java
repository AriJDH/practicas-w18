package com.starwars.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PersonajeDto {
    String name;
    Integer height;
    Integer mass;
    String gender;
    String homeWorld;
    String species;

}


