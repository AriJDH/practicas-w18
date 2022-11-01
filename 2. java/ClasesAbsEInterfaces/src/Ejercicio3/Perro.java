package Ejercicio3;

public class Perro extends Animal implements ICarnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("guau");
    }

    @Override
    public void comerAnimal() {
        System.out.println("come carne");
    }
}
