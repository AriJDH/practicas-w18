package com.meli.Animals;

public class Cow extends Animal implements IHerbivorous{
    @Override
    public void makeSound() {
        System.out.println("Muuu");
    }
}
