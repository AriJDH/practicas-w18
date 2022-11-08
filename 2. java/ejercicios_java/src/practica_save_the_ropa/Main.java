package practica_save_the_ropa;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(new Prenda("Chanel", "Camisa"));
        prendas.add(new Prenda("Pantalon", "Chanel"));

        List<Prenda> prendas2 = new ArrayList<>();
        prendas2.add(new Prenda("Camisa", "Camisa"));
        prendas2.add(new Prenda("Pantalon", "Chanel"));

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendas);
        guardaRopa.guardarPrendas(prendas2);

        guardaRopa.mostrarPrendas();
    }
}
