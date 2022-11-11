package com.example.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PersonajeDTO {
    private String name;
    private int height;
    private int mass;
    private String gender;
    private String homeworld;
    private String species;
}
