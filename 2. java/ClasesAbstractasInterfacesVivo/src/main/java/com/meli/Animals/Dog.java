package com.meli.Animals;

public class Dog extends Animal implements ICarnivorous{
    @Override
    public void makeSound() {
        System.out.println("Guau");
    }
}
