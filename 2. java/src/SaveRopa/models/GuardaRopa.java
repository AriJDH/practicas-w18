package SaveRopa.models;

import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> compartimientos;
    private static int ultimaClave = 1;

    public Map<Integer, List<Prenda>> getCompartimientos() {
        return compartimientos;
    }

    public void setCompartimientos(Map<Integer, List<Prenda>> compartimientos) {
        this.compartimientos = compartimientos;
    }

    public static int getUltimaClave() {
        return ultimaClave;
    }

    public static void setUltimaClave(int ultimaClave) {
        GuardaRopa.ultimaClave = ultimaClave;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        this.compartimientos.put(++ultimaClave,listaDePrenda);
        return ultimaClave;
    }

    public void mostrarPrendas(){
        this.compartimientos.forEach((k,v) -> System.out.println(String.valueOf(k) + v));
    }

    public void devolverPrendas(Integer numero){
        System.out.println(this.compartimientos.get(numero));
    }
}
