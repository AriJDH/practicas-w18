package ClasesAbstractas_e_Interfaces.Ejercicio3.Animales;

import ClasesAbstractas_e_Interfaces.Ejercicio3.Interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
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
