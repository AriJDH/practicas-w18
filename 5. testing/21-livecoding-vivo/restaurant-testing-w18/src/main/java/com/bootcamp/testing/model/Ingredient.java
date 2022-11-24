package com.bootcamp.testing.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ingredient {
    private String name;
    private Integer quality;
    private Integer quantity;
    private Integer calories;

    public boolean hasSameName(String name){
        return this.name.equalsIgnoreCase(name);
    }

    public Double calcTotalCalories(){
        return quantity * calories / 100D;
    }
}
