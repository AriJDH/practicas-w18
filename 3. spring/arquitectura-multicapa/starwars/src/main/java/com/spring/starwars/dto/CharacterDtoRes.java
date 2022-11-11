package com.spring.starwars.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CharacterDtoRes {
    private String name;
    private Integer height;
    private Integer mass;
    private String gender;
    private String homeworld;
    private String species;
}
