import clases.GuardaRopa;
import clases.Prenda;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Pantalon", "Blusa");
        Prenda prenda2 = new Prenda("Falda", "Pans");
        List<Prenda> listP = Arrays.asList(prenda1, prenda2);
        GuardaRopa guardaRopa = new GuardaRopa();
        guardaRopa.guardarPrendas(listP);
        System.out.println("****** Se muestra las prendas *****");
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(1));
    }
}