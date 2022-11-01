package ClasesAbstractas_e_Interfaces.Ejercicio3.Animales;

import ClasesAbstractas_e_Interfaces.Ejercicio3.Interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {
    public Vaca() {
        super("Vaca");
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comer hierba");
    }
}
