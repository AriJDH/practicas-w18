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

}
