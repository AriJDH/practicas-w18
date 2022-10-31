package ej3;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();

        perro.comerCarne();
        gato.comerCarne();
        vaca.comerHierba();

        perro.comerAnimal(gato);
        gato.comerAnimal(perro);
    }
}
