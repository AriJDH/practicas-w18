package com.bootcamp.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PersojeDto {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeworld;
    private String species;


}
