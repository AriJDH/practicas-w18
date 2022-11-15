package com.example.ejercicio_1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Personaje {

    private String name;
    private Double height;
    private Double mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private Integer birthYear;
    private String gender;
    private String homeworld;
    private String species;

}
