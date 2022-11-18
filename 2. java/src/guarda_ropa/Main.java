package guarda_ropa;

import guarda_ropa.model.GuardaRopa;
import guarda_ropa.model.Prenda;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        GuardaRopa guardaRopa = new GuardaRopa();

        Prenda p1 = new Prenda("Gucci", "Rt200");
        Prenda p2 = new Prenda("Lacoste", "Verde");

        List<Prenda> prendas1 = new ArrayList<>();

        prendas1.add(p1);
        prendas1.add(p2);

        int lugar1 = guardaRopa.guardarPrendas(prendas1);
        System.out.println("============================================================");
        System.out.println("=============== Todas las prendas guardadas ================");
        guardaRopa.mostrarPrendas();

        List<Prenda> prendasRetornadas = guardaRopa.devolverPrendas(lugar1);

        System.out.println("============================================================");
        System.out.println("==================== Prendas retornadas ====================");
        prendasRetornadas.forEach(p -> System.out.println(p));

    }
}
