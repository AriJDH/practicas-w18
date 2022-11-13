package com.example.starwars.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Character {
    String name;
    String height, mass;
    String hair_color, skin_color, eye_color, birth_year, gender, homeworld, species;

    public Integer getHeight(){
        try{
            return Integer.valueOf(this.height);
        }catch (NumberFormatException e){
            return null;
        }
    }

    public Integer getMass(){
        try{
            return Integer.valueOf(this.mass);
        }catch (NumberFormatException e){
            return null;
        }
    }
}
