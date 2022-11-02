package ejercicio3_Animal.Model;

import ejercicio3_Animal.Intefaz.Carnivorous;

public class Cat extends Animal implements Carnivorous {

    public Cat() {
    }


    @Override
    public String toString() {
        return "Dog{} " + super.toString();
    }

    @Override
    public void makeSound() {
        System.out.print("Miau - ");
    }



}
