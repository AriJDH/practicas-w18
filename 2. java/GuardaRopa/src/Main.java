import guardaRopa.Campera;
import guardaRopa.GuardaRopa;
import guardaRopa.Pantalon;
import guardaRopa.Prenda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Pantalon pantalon = new Pantalon("Gucci", "Recto");
        Campera campera = new Campera("Prada", "Abrigada");
        List<Prenda> prendas = new ArrayList<Prenda>();
        prendas.add(pantalon);
        prendas.add(campera);
        Map<Integer,List<Prenda>> mapa = new HashMap<Integer,List<Prenda>>();
        GuardaRopa guardaRopa = new GuardaRopa(mapa, 0);
        int codigo = guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
    }
}
