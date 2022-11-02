package ejercicio3_Animal.Model;

import ejercicio3_Animal.Intefaz.Herbivorous;

public class Cow extends Animal implements Herbivorous {

    public Cow() {
    }

    @Override
    public String toString() {
        return "Cow{} " + super.toString();
    }

    @Override
    public void makeSound() {
        System.out.print("Muuuu - ");
    }



}
