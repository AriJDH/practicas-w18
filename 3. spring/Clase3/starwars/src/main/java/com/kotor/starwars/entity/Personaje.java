package com.kotor.starwars.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
public class Personaje {

    private String name;
    private String height;
    private String mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String homeworld;
    private String species;

   public Integer getHeight() {
        try {
            return Integer.valueOf(this.height);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public Integer getMass() {
        try {
            return Integer.valueOf(this.mass);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}
