import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> prendas;
    private Integer contador;

    public GuardaRopa() {
        this.prendas = new HashMap<>();
        this.contador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        prendas.put(++contador,listaDePrenda);
        return contador;
    }

    public void mostrarPrendas(){
        for (Map.Entry<Integer,List<Prenda>> prenda:prendas.entrySet()) {
            Integer clave = prenda.getKey();
            List<Prenda> elementos = prenda.getValue();
            System.out.println("La clave de las prendas es: "+clave);
            System.out.println("Las prendas que contiene son: "+elementos);
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return prendas.get(numero);
    }

    public Map<Integer, List<Prenda>> getPrendas() {
        return prendas;
    }

    public void setPrendas(Map<Integer, List<Prenda>> prendas) {
        this.prendas = prendas;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "prendas=" + prendas +
                ", contador=" + contador +
                '}';
    }
}
