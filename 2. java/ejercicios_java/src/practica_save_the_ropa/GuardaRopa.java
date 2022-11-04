package practica_save_the_ropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> casillero;

    public GuardaRopa() {
        this.casillero = new HashMap<>();
    }

    public Map<Integer, List<Prenda>> getCasillero() {
        return casillero;
    }

    public void setCasillero(Map<Integer, List<Prenda>> casillero) {
        this.casillero = casillero;
    }

    public Integer guardarPrendas(List<Prenda> prenda) {

        int indice = casillero.size() + 1;
        casillero.put(indice, prenda);

        return indice;
    }

    public void mostrarPrendas() {
        for (Map.Entry<Integer, List<Prenda>> mapa : casillero.entrySet()) {

            System.out.println("Numero casillero " + mapa.getKey() + " Prendas " + mapa.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return casillero.get(numero);
    }
}
