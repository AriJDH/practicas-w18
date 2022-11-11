package ejercicio1.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Integer numero = 0;
    Map<Integer, List<Prenda>> prendas = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> prendas) {

        numero++;
        this.prendas.put(numero, prendas);
        return numero;
    }

    public void mostrarPrendas() {

        prendas.forEach((key, value) -> System.out.println(key + "=" + value + " "));
        System.out.println();
    }

    public List<Prenda> devolverPrendas(Integer numero) {

        List<Prenda> result = prendas.get(numero);
        prendas.remove(numero);
        return result;
    }

}
