package ejercicio3;

import ejercicio3.clases.Gato;
import ejercicio3.clases.Perro;
import ejercicio3.clases.Vaca;
import ejercicio3.clases.Zorro;

public class Test {
    public static void main(String[] args) {
        Gato gato = new Gato("Michi");
        gato.emitirSonidos();
        gato.comerCarne();
        System.out.println("---------------------------------------------------------");

        Perro perro = new Perro("Chucho");
        perro.emitirSonidos();
        perro.comerCarne();
        System.out.println("---------------------------------------------------------");

        Vaca vaca = new Vaca("Lola");
        vaca.emitirSonidos();
        vaca.comerHierba();
        System.out.println("---------------------------------------------------------");

        Zorro zorro = new Zorro("Temor");
        zorro.emitirSonidos();
        zorro.comerCarne();
        zorro.comerAnimal("Gato");
    }
}
