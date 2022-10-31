package practica_abstracta_interfaces_vivo.ejercicio3.clases;

import practica_abstracta_interfaces_vivo.ejercicio3.interfaces.IAlimentacionAnimal;

public class Perro extends Animal implements IAlimentacionAnimal {

    @Override
    public void emitirSonido() {
        System.out.println("Guauu");
    }

    @Override
    public void comerAnimal() {
        System.out.println("come carne y de vez en cuando hierba");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }

    @Override
    public void comerHierba() {
        System.out.println("Come hierba");
    }

}
