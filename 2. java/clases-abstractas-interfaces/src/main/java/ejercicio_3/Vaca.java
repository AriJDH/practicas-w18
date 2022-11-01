package ejercicio_3;

public class Vaca extends Animal implements Herviboro{

    @Override
    void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba!");
    }

    @Override
    void comer() {
        comerHierba();
    }
}
