public class Test {

    public static void main(String[] args) {
        Perro perro = new Perro();
        Main main = new Main();
        perro.emitirSonido();
        main.comerAnimal(perro);
        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        main.comerAnimal(vaca);
        Gato gato = new Gato();
        gato.emitirSonido();
        main.comerAnimal(gato);
    }
}