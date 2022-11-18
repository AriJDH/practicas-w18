package com.multiacapa.starswars.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaje {
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String homeWorld;
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

    public String getHomeWorld() {
        return this.homeWorld;
    }
}

