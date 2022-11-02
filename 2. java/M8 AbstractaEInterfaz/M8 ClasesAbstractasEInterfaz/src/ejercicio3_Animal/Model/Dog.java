package ejercicio3_Animal.Model;

import ejercicio3_Animal.Intefaz.Carnivorous;

public class Dog extends Animal implements Carnivorous{

    public Dog() {
    }

    @Override
    public String toString() {
        return "Dog{} " + super.toString();
    }

    @Override
    public void makeSound() {
        System.out.print("Guau - ");
    }

}
