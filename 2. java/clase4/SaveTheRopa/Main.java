import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Awada","Campera");
        Prenda prenda2 = new Prenda("Zara","Bufanda");
        List<Prenda> lista = new ArrayList<>();
        lista.add(prenda1);
        lista.add(prenda2);
        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(lista);
        guardaRopa.mostrarPrendas();
        System.out.println(guardaRopa.devolverPrendas(1));
    }
}