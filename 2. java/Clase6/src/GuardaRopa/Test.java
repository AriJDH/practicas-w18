package GuardaRopa;

import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Prueba", "Prueba");
        Prenda prenda2 = new Prenda("Prueba1", "Prueba2");
        List<Prenda> listP = Arrays.asList(prenda1, prenda2);
        Guardarropa guardaRopa = new Guardarropa();
        guardaRopa.guardarPrendas(listP);
        System.out.println("****** Se muestra las prendas *****");
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(1));
    }
}