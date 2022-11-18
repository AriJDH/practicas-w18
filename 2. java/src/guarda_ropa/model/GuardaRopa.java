package guarda_ropa.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> guardaRopa;
    private int contador;

    public GuardaRopa() {
        this.guardaRopa = new HashMap<>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaPrendas) {
        int aux = contador;
        guardaRopa.put(aux, listaPrendas);
        contador++;
        System.out.println("============================================================");
        System.out.println("==================== Prendas Guardadas =====================");
        System.out.println("Cantidad de prendas: " + listaPrendas.size() + "\nLugar: " + aux);
        return aux;
    }

    public void mostrarPrendas() {
        guardaRopa.values().forEach(l -> l.forEach(System.out::println));
    }

    public List<Prenda> devolverPrendas(Integer num) {
        List<Prenda> prendas = guardaRopa.get(num);
        guardaRopa.remove(num);
        contador--;
        return prendas;
    }
}
