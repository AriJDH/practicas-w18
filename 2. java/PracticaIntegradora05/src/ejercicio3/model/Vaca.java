package ejercicio3.model;

import ejercicio3.interfaces.IHervivoro;

public class Vaca extends Animal implements IHervivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuu !");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comiendo hierba !");
    }

    @Override
    public void comer() { comerHierba(); }

}
