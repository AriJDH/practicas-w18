package InterfacesYClaseAbstractas.animales.clases;

import InterfacesYClaseAbstractas.animales.interfaces.Herviboro;

public class Vaca extends Animales implements Herviboro {

    public Vaca(double altura, double peso, String raza) {
        super(altura, peso, raza);
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuuuuuu");
    }

    @Override
    public void comerAnimal() {
        comerHierva();
    }

    @Override
    public void comerHierva() {
        System.out.println("la vaca come hiervas");
    }
}
