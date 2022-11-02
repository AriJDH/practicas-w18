import interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Miauuuu");
    }
}
