package clases;

import interfaces.Carnivoro;
import interfaces.Herbivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void sonar() {
        System.out.println("guau !");
    }

    @Override
    public void comer() {
        System.out.println("Soy un perro comiendo carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Me estoy comiendo un " +animal.getClass().getSimpleName());
    }
}
