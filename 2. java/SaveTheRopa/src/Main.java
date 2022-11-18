import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Prenda prenda1 = new Prenda("Awada","Campera");
        Prenda prenda2 = new Prenda("Zara","Bufanda");
        List<Prenda> lista1 = new ArrayList<>();
        lista1.add(prenda1);
        lista1.add(prenda2);
        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(lista1);

        Prenda prenda3 = new Prenda("Dior","Saco");
        Prenda prenda4 = new Prenda("Prüne","Bolso");
        List<Prenda> lista2 = new ArrayList<>();
        lista2.add(prenda3);
        lista2.add(prenda4);

        guardaRopa.guardarPrendas(lista2);
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        guardaRopa.mostrarPrendas();
        System.out.println("----------------------------------------------------------------------------------------------------------------------");
        guardaRopa.devolverPrendas(1);
        guardaRopa.devolverPrendas(2);
    }
}