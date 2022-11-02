package animales;

public abstract class Animal {
    private String nombre;

    public Animal(String nombre) {
        this.nombre = nombre;
    }

    public abstract void emitirSonido();
    protected abstract void comer();

    public static void comerAnimal(Animal animal){
        animal.comer();
    };

    @Override
    public String toString() {
        return nombre;
    }
}
