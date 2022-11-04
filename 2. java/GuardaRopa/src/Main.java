import guardaRopa.Campera;
import guardaRopa.GuardaRopa;
import guardaRopa.Pantalon;
import guardaRopa.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Pantalon pantalon = new Pantalon("Gucci", "Recto");
        Campera campera = new Campera("Prada", "Abrigada");
        List<Prenda> prendas = new ArrayList<Prenda>();
        prendas.add(pantalon);
        prendas.add(campera);
        GuardaRopa guardaRopa = new GuardaRopa();
        int codigo = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
    }
}
