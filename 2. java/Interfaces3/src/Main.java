public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.comerAnimal();
        perro.emitirSonido();

        gato.comerAnimal();
        gato.emitirSonido();

        vaca.comerAnimal();
        vaca.emitirSonido();

    }
}