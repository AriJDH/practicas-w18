package clase3_a_ClasesAbsEInterfaces.Ejercicio3;

public class Gato extends Animal implements Carnivoro{
    @Override
    public void emitirSonidos() {
        System.out.println("Miauuu!");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Me estoy comiendo un " + animal.getClass().getSimpleName());
    }
}
