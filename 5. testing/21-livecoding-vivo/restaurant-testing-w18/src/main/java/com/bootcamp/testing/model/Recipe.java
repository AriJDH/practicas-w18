package com.bootcamp.testing.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@EqualsAndHashCode
public class Recipe {
    private String name;
    private String description;
    private List<Ingredient> ingredients;

    public boolean hasSameName(String name){
        return this.name.equalsIgnoreCase(name);
    }
}