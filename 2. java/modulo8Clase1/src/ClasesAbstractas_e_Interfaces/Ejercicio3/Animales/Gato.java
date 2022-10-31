package ClasesAbstractas_e_Interfaces.Ejercicio3;

public class Gato extends Animal implements ICarnivoro {
    public Gato() {
        super("Gato");
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }

    @Override
    public void comerAnimal(Animal a) {
        System.out.println("Comiendo un " + a.getEspecie());

    }
}
