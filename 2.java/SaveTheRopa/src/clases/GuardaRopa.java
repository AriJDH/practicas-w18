package clases;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    HashMap<Integer, List<Prenda>> casilleros;

    public GuardaRopa() {
        this.casilleros = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrendas(List<Prenda> prendas){
        int indice = casilleros.size() + 1;
        this.casilleros.put(indice, prendas);
        return indice;
    }

    public void mostrarPrendas(){
        this.casilleros.forEach((k,v) -> System.out.println("Casillero nro : " + k + ": Ropas: " + v.toString()));

    }
}
