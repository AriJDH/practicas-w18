package com.mercadolibre.starwars.entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {
    private String name;
    @Getter(AccessLevel.NONE)
    private String height;
    @Getter(AccessLevel.NONE)
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
