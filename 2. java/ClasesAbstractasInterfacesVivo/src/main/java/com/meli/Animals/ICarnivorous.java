package com.meli.Animals;

public interface ICarnivorous {
    public default void eatMeat(){
        System.out.println("Comiendo carne");
    }
}
