import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private int contador;
    private Map<Integer, List<Prenda>> listaPrendas;

    public GuardaRopa() {
        this.contador = 0;
        this.listaPrendas = new HashMap<>();
    }

    public Integer guardarRopa(List<Prenda> listaDePrendas){
        this.contador++;
        this.listaPrendas.put(contador, listaDePrendas);
        return contador;
    }

    public void mostrarRopa(){
        for (Integer id: listaPrendas.keySet()) {
            System.out.println("Armario " + id + ": " + listaPrendas.get(id));
        }
    }

    public void consultarRopa(Integer id){
        System.out.println("Armario " + id + ": " + listaPrendas.get(id));
    }

    public List<Prenda> devolverPrendas(Integer id){
        return listaPrendas.remove(id);
    }
}
