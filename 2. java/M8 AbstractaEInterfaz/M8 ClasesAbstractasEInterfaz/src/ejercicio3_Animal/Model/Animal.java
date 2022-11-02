package ejercicio3_Animal.Model;

import ejercicio3_Animal.Intefaz.AnimalDiet;

public abstract class Animal implements AnimalDiet{

    private String diet;

    public abstract void makeSound();

    public Animal() {
    }

    public Animal(String diet) {
        this.diet = diet;
    }

    public String getDiet() {
        return diet;
    }

    public void setDiet(String diet) {
        this.diet = diet;
    }


    @Override
    public String toString() {
        return "Animal{" +
                "diet='" + diet + '\'' +
                '}';
    }
}
