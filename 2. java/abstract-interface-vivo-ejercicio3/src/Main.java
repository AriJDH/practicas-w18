public class Main {
    public static void main(String[] args) {
        System.out.println("Apertura de granja!");
        Perro belle = new Perro();
        Perro goofy = new Perro();
        Gato tomas = new Gato();
        Vaca sally = new Vaca();
        belle.emitirSonido();
        belle.comerCarne();
        sally.emitirSonido();
        tomas.emitirSonido();
        goofy.comerAnimal();
        sally.comerHierba();
    }
}