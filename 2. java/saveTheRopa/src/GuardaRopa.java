import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> prendas = new HashMap<>();
    private Integer contador=0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        contador +=1;
        prendas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        System.out.println(prendas.toString());
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }

    @Override
    public String toString() {
        return "\nGuardaRopa " +
                "prendas=" + prendas +
                ", contador=" + contador +
                '}';
    }
}
