package com.example.starwars.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersonajeResponseDto {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;
}
