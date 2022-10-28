package clases;

import interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void sonar() {
        System.out.println("miauuuu");
    }

    @Override
    public void comer() {
        System.out.println("Soy un gato comiendo carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Me estoy comiendo un " +animal.getClass().getSimpleName());
    }
}
