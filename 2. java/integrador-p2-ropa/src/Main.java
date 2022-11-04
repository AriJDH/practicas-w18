import model.GuardaRopa;
import model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");

        Prenda prenda1 = new Prenda("Tomy Hilfiger", "Tshirt");
        Prenda prenda2 = new Prenda("Tomy Hilfiger", "Polo");
        Prenda prenda3 = new Prenda("Levis", "Jeans 501");
        Prenda prenda4 = new Prenda("Bowen", "Shorts");
        List<Prenda> prendas = new ArrayList<Prenda>();
        List<Prenda> prendas2 = new ArrayList<Prenda>();
        prendas.add(prenda1);
        prendas.add(prenda2);
        prendas2.add(prenda3);
        prendas2.add(prenda4);

        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(prendas2);

        guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();

//        System.out.println("################## devolver prendas 0");
//        System.out.println(guardaRopa.devolverPrendas(0));
//        System.out.println("################## devolver prendas 1");
//        System.out.println(guardaRopa.devolverPrendas(1));


    }


}