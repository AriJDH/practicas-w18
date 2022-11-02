public class Main {
    public static void main(String[] args) {
        Gato gato = new Gato();
        gato.comerCarne();
        gato.emitirSonido();

        Perro perro = new Perro();
        perro.comerCarne();
        perro.emitirSonido();

        Vaca vaca = new Vaca();
        vaca.comerHierba();
        vaca.emitirSonido();
    }
}
