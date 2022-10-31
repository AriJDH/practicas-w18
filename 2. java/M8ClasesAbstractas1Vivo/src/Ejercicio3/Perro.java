package Ejercicio3;

public class Perro extends Animal implements ComerCarne{
    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Los perros comemos carne");
    }
}
