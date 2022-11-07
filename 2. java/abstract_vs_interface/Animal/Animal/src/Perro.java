import interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void emitirSonido() {
        System.out.println("GUAU GUAU");
    }

    @Override
    public void comerAnimal(Animal animal) {
        if (animal == Perro.this){
            emitirSonido();
            comerCarne();
        }
    }

    @Override
    public void comerCarne() {
        System.out.println("Soy un perro carnivoro");
    }
}
