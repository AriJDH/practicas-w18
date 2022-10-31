package clase3_a_ClasesAbsEInterfaces.Ejercicio3;

public class Perro extends Animal implements Carnivoro{

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne...");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Me estoy comiendo un " + animal.getClass().getSimpleName());
    }

    @Override
    public void emitirSonidos() {
        System.out.println("guau!!");
    }

}
