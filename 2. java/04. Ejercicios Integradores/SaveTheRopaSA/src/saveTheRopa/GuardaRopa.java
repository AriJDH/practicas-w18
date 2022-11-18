package saveTheRopa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Integer contador = 0;
    private Map<Integer, List<Prenda>> guardaRopa = new HashMap<>();

    public Integer guardarPrendas(List<Prenda> listaDePrendas) {
        this.guardaRopa.put(++contador, listaDePrendas);
        return this.contador;
    }

    public void mostrarPrendas(){
        System.out.println("Contenidos del Guarda Ropa:");
        for(Map.Entry<Integer,List<Prenda>> g : this.guardaRopa.entrySet()){
            System.out.println(g);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.guardaRopa.remove(numero);
    }

    public void consultarPrendas(Integer numero){
        System.out.println(this.guardaRopa.get(numero));
    }

}
