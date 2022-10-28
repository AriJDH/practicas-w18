package Ejercicio3;

public class Test {
    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();
        Gato gato = new Gato();
        gato.comerCarne();
        gato.emitirSonido();
        Vaca vaca = new Vaca();
        vaca.comerHierba();
        vaca.emitirSonido();
    }


}
