package ejercicio1;

import ejercicio1.model.GuardaRopa;
import ejercicio1.model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        GuardaRopa guardaRopa = new GuardaRopa();

        List<Prenda> misPrendas = new ArrayList<>();
        misPrendas.add(new Prenda("h", "h2"));
        misPrendas.add(new Prenda("v", "v2"));
        misPrendas.add(new Prenda("f", "f2"));

        Integer ticket = guardaRopa.guardarPrendas(misPrendas);
        guardaRopa.mostrarPrendas();

        List<Prenda> misPrendas2 = new ArrayList<>();
        misPrendas2.add(new Prenda("hh", "hh2"));
        misPrendas2.add(new Prenda("vv", "vv2"));
        misPrendas2.add(new Prenda("ff", "ff2"));
        Integer ticket2 = guardaRopa.guardarPrendas(misPrendas2);


        guardaRopa.mostrarPrendas();


        List<Prenda> retiroPrendas = guardaRopa.devolverPrendas(ticket);

        guardaRopa.mostrarPrendas();
    }

}
