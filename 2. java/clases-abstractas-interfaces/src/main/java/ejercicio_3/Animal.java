package ejercicio_3;

public abstract class Animal {

    abstract void emitirSonido();
    abstract void comer();

    public static void comerAnimal(Animal animal) {
        animal.comer();
    };


}
