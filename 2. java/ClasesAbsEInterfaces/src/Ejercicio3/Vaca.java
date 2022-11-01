package Ejercicio3;

public class Vaca extends Animal implements IHerviboro{
    @Override
    public void emitirSonido() {
        System.out.println("Muu");
    }

    @Override
    public void comerAnimal() {
        System.out.println("come hierbas");
    }
}
