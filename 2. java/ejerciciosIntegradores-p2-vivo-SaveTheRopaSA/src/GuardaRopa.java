import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> mapa = new HashMap<>();
    private Integer ID = 0;

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
//        ID+=1;
        mapa.put(ID+=1, listaDePrenda);
        return ID;
    }

    public void mostrarPrendas() {
        mapa.forEach((id,prendas) -> System.out.println(
                "ID=" + id + " - " + prendas.toString()));
    }

    public List<Prenda> devolverPrendas(Integer numero) {
        return mapa.get(numero);
    }

    public Map<Integer, List<Prenda>> getMapa() {
        return mapa;
    }

    public void setMapa(Map<Integer, List<Prenda>> mapa) {
        this.mapa = mapa;
    }
}
