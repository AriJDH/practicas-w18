package clase5_a_Ropa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Prenda> listaDePrendas = new ArrayList<>();
        Prenda buzo = new Prenda("Nike","truchini");
        Prenda remera = new Prenda("Adidas", "manga corta");

        List<Prenda> listaDePrendas2 = new ArrayList<>();
        Prenda pantalon = new Prenda("Nike","cortos");
        Prenda pollera = new Prenda("Reebok", "larga");

        List<Prenda> listaDePrendas3 = new ArrayList<>();
        Prenda medias = new Prenda("Gap","abrigadas");
        Prenda campera = new Prenda("Puma", "calurosa");

        listaDePrendas.add(buzo);
        listaDePrendas.add(remera);

        listaDePrendas2.add(pantalon);
        listaDePrendas2.add(pollera);

        listaDePrendas3.add(medias);
        listaDePrendas3.add(campera);

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(listaDePrendas);
        guardaRopa.guardarPrendas(listaDePrendas2);
        guardaRopa.guardarPrendas(listaDePrendas3);


        guardaRopa.devolverPrendas(2).stream().forEach(System.out::println);
    }
}
