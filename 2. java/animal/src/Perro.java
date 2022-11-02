import interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("Guauu");
    }
}
