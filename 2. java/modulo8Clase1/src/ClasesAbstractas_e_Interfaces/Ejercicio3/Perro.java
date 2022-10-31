package ClasesAbstractas_e_Interfaces.Ejercicio3;

public class Perro extends Animal implements Carnivoro {
    public Perro() {
        super("Perro");
    }

    @Override
    public void emitirSonido() {
        System.out.println("guau");
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
