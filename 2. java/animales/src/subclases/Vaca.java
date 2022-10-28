package subclases;

import interfaces.Herviboro;
import superclase.Animales;

public class Vaca extends Animales implements Herviboro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuu!");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca está comiendo hierva");
    }
}
