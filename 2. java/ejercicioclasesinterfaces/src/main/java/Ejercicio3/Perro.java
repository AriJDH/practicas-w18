package Ejercicio3;

public class Perro extends Animal implements Carnivoro{
    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau!");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro *Come carne*");

    }
}
