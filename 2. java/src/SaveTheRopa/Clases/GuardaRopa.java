package SaveTheRopa.Clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class GuardaRopa {
    private int contador;
    private Map<Integer, List<Prenda>> dictionary = new HashMap<>();

    public int guardarPrendas(List<Prenda> prendas){
        contador ++;
        dictionary.put(contador,prendas);
        return contador;
    }

    public void mostrarPrenda(){
        Stream.of(dictionary).forEach(System.out::println);
    }

    public List<Prenda> devolverPrendas(int codigoPrenda) {
        try {
            return dictionary.get(codigoPrenda);
        } catch (Exception e) {
            System.out.println("No existen la prenda # "+ codigoPrenda);
            return null;
        }
    }
}
