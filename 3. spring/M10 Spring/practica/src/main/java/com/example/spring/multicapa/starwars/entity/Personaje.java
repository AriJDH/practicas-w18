package com.example.spring.multicapa.starwars.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Personaje {

    private String name;
    private String height;
    private String mass;

    /*@JsonProperty("nombreDeLaKeyJson") así por ejemplo evitamos tener que modificar el atributo hairColor por hair_color*/
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;


    public Integer getHeight(){
        try {
            return Integer.valueOf(this.height);
        } catch (NumberFormatException e){
            return null;
        }
    }

    public Integer getMass(){
        try {
            return Integer.valueOf(this.mass);
        } catch (NumberFormatException e){
            return null;
        }
    }


}
