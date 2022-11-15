package clase5_a_Ropa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private Map<Integer, List<Prenda>> guardador ;
    private int identificador;

    public GuardaRopa() {
        this.guardador = new HashMap<Integer, List<Prenda>>();
        this.identificador = 0;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        int identificar = guardador.size()+1;
        guardador.put(identificar,listaDePrenda);
        return identificar;
    }

    public void mostrarPrendas(){
        for (int clave : guardador.keySet()){
            System.out.println("Identificador "+clave+" ");
            System.out.println(guardador.get(clave));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return guardador.get(numero);
    }
}
