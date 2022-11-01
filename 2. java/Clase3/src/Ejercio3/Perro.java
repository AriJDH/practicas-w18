package Ejercio3;

public class Perro extends Animal implements Carnivoro{
    private String nombre;

    public Perro(String nombre) {
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
        System.out.println("Guau");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("El perro se comio una " + animal.getNombre());
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro comio carne");
    }
}
