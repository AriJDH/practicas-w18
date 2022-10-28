package practica_abstracta_interfaces_vivo.ejercicio3;

public class Main {

    public static void main(String[] args) {
        Perro perro = new Perro();
        perro.emitirSonido();

        Gato gato = new Gato();
        gato.emitirSonido();

        Vaca vaca = new Vaca();
        vaca.emitirSonido();
    }
}
