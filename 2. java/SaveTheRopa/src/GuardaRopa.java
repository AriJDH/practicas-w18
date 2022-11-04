import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int id = 0;
    Map<Integer, List<Prenda>> guardaRopa = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        guardaRopa.put(++id, listaDePrenda);
        return id;
    }

    public void mostrarPrendas(){
        guardaRopa.forEach((i, value) -> System.out.println("Id: " + i + "Prendas: " + value));
    }

    public List<Prenda> devolverPrendas(Integer id){
        List value = guardaRopa.get(id);
        return value;
    }
}
