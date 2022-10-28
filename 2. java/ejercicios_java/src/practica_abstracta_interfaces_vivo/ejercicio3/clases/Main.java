package practica_abstracta_interfaces_vivo.ejercicio3.clases;

public class Main {

    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.emitirSonido();
        perro.comerCarne();

        Gato gato = new Gato();
        gato.emitirSonido();
        gato.comerCarne();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
        vaca.comerCarne();

    }
}
