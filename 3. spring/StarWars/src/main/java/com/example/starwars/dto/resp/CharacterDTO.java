package com.example.starwars.dto.resp;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class CharacterDTO {
    private String name;
    private String height;
    private String mass;
    private String gender;
    private String homeWorld;
    private String species;
}
