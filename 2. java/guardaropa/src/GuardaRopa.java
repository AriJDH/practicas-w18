import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda> > prendas;
    private int contador;

    public GuardaRopa() {
        this.prendas = new HashMap<Integer, List<Prenda>>();
        this.contador = 1;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        prendas.put(contador, listaDePrenda);
        contador++;
        return contador - 1;
    }

    public void mostrarPrendas() {
        prendas.forEach((k,v) -> System.out.println("Clave: " + k + ", Valor: " + v));
    }
    
    public List<Prenda> devolverPrendas(Integer numero) {
        boolean existe = false;
        for(Map.Entry<Integer,List<Prenda>> m : prendas.entrySet()) {
            if(numero.equals(m.getKey())){
                existe = true;
            }
        }
        if(existe) {
            return prendas.get(numero);
        }
        return null;
    }

}
