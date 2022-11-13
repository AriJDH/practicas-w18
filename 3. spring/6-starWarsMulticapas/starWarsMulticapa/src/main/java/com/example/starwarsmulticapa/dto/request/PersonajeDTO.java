package com.example.starwarsmulticapa.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter

public class PersonajeDTO {

    private String name;
    private String gender;
    private String homeworld;
    private String species;
    private Integer height;
    private Integer mass;
}
