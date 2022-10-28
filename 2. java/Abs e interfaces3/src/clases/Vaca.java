package clases;

import interfaces.Herbivoro;

public class Vaca extends Animal implements Herbivoro {
    @Override
    public void sonar() {
        System.out.println("muuuuu");
    }

    @Override
    public void comer() {
        System.out.println("Soy una Vaca comiendo hierba");
    }
    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Me estoy comiendo un " +animal.getClass().getSimpleName());
    }
}
