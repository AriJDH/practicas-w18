package Ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonido() {
        System.out.println("Miauu");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato *Come carne*");
    }
}
