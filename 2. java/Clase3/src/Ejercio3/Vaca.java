package Ejercio3;

public class Vaca extends Animal implements Herviboro{

    private String nombre;

    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("La vaca no come " + animal.getNombre() + ". Es hervivora.");
    }

    @Override
    public void comerHierva() {
        System.out.println("La vaca comio pasto");
    }
}
