package clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> casillero;

    public GuardaRopa(Map<Integer, List<Prenda>> casillero) {
        this.casillero = casillero;
    }

    public Map<Integer, List<Prenda>> getCasillero() {
        return casillero;
    }

    public void setCasillero(Map<Integer, List<Prenda>> casillero) {
        this.casillero = casillero;
    }

    public void mostrarPrendas() {
        getCasillero()
                .entrySet()
                .stream()
                .forEach(e -> System.out.println("clave..:" + e.getKey() + "valor..:" + e.getValue().stream()));
    }
}
