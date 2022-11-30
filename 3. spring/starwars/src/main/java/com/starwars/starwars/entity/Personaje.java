package com.starwars.starwars.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Personaje {

    String name;
    int height;
    int mass;
    String hairColor;
    String skinColor;
    String eyeColor;
    String birthYear;
    String gender;
    String homeworld;
    String species;
}
