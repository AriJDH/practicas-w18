package Ejercicio3;

public class Vaca extends Animal implements ComerHierba{
    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Las vacas comemos hierba");
    }
}
