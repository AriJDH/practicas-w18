import interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("MIAU MIAU");
    }

    @Override
    public void comerAnimal(Animal animal) {
        if (animal == Gato.this){
            emitirSonido();
            comerCarne();
        }
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un gato carnivoro");
    }
}
