package ejercicio3.model;

import ejercicio3.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau !");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne !");
    }

    @Override
    public void comer() {
        comerCarne();
    }

}
