import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> guardaRopa = new HashMap<Integer, List<Prenda>>();
    private int contador = 1;

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
            guardaRopa.put(contador, listaDePrenda);
            contador++;
            return contador-1;
    }

    public void mostrarPrendas(){
        guardaRopa.forEach( (k, prendas) -> {
            System.out.println("Guarda ropa nro: " + k);
            prendas.forEach(Prenda::imprimir);
            System.out.println("-------------------------------\n");
        } );
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return guardaRopa.get(numero);
    }




}
