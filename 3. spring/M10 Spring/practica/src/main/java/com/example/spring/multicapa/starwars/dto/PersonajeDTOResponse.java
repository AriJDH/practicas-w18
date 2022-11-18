package com.example.spring.multicapa.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PersonajeDTOResponse {

    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;

}
