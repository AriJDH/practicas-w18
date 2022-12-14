import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class GuardaRopa {

    private Integer contador;
    private Map<Integer, List<Prenda>> diccionario;

    public GuardaRopa(){
        this.contador = 0;
        this.diccionario = new HashMap<>();
    }

    public Integer GuardarPrendas(List<Prenda> listaDePrenda) {
        Integer id = this.contador;
        diccionario.put(id, listaDePrenda);
        this.contador++;
        return id;
    }

    public void mostrarPrendas(){
        for (Integer key: diccionario.keySet()){
            List<Prenda> listaDePrenda = diccionario.get(key);
            System.out.println(listaDePrenda);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        List<Prenda> prendas = diccionario.remove(numero);
        return prendas;
    }

}
