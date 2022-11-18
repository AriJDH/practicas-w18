import saveTheRopa.GuardaRopa;
import saveTheRopa.Prenda;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GuardaRopa gr = new GuardaRopa();
        Prenda p1 = new Prenda("Zara", "Chaleco");
        Prenda p2 = new Prenda("Montagne", "Campera");

        Integer ticket = gr.guardarPrendas(Arrays.asList(p1,p2));

        gr.mostrarPrendas();
        gr.consultarPrendas(ticket);
        gr.devolverPrendas(ticket);

        gr.mostrarPrendas();

    }
}
