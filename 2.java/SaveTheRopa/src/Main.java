import clases.GuardaRopa;
import clases.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa meli = new GuardaRopa();

        Prenda remera = new Prenda("Nike", "Musculosa");
        Prenda pantalon = new Prenda("Cargo", "Trabajo");

        List<Prenda> prendas = new ArrayList<>();
        prendas.add(remera);
        prendas.add(pantalon);

        meli.guardarPrendas(prendas);
        meli.mostrarPrendas();

    }
}