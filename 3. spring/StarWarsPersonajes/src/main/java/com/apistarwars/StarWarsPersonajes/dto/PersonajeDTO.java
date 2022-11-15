package com.apistarwars.StarWarsPersonajes.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class PersonajeDTO {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}