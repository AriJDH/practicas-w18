package animales;

public class Perro extends Animal implements ComerCarne{

    @Override
    public void emitirSonido() {
        System.out.println("Los perros emitimos como sonido: Guau guau....");
    }

    @Override
    public void comerCarne() {
        System.out.println("Los perros comemos carne");
    }
}
