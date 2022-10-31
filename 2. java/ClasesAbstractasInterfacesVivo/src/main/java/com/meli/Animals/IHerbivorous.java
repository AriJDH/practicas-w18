package com.meli.Animals;

public interface IHerbivorous {
    public default void eatGrass(){
        System.out.println("Comiendo hierba");
    }
}
