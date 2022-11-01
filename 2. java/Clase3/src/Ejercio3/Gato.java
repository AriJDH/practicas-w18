package Ejercio3;

public class Gato extends Animal implements Carnivoro{
    private String nombre;

    public Gato(String nombre) {
        super(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("El gato se comio una " + animal.getNombre());
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato comio carne");
    }
}
