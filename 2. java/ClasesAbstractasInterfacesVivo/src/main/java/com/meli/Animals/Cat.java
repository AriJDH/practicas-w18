package com.meli.Animals;

public class Cat extends Animal implements ICarnivorous {
    @Override
    public void makeSound() {
        System.out.println("Miau");
    }
}
