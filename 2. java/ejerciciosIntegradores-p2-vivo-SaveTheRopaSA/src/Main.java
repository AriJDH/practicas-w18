import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello SaveTheRopa S.A!");
        List<Prenda> prendas = new ArrayList<>();
        Map<Integer, List<Prenda>> mapa = new HashMap<>();
//        mapa.put(1,prendas);
        GuardaRopa guardaRopa = new GuardaRopa();
        prendas.add(new Prenda("Aaaaa", "Bbbbb"));
        prendas.add(new Prenda("Cccccc", "Ddddd"));
        guardaRopa.guardarPrendas(prendas);
        System.out.println(guardaRopa.guardarPrendas(prendas));
        prendas.add(new Prenda("Aaaaa", "Bbbbb"));
        prendas.add(new Prenda("Cccccc", "Ddddd"));
        guardaRopa.guardarPrendas(prendas);
        guardaRopa.mostrarPrendas();
    }
}