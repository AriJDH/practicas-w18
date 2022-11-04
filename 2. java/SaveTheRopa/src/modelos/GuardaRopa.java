package modelos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    private static int ultimaClave = 0;
    Map<Integer, List<Prenda>> compartimientos;

    public GuardaRopa() {
        this.compartimientos = new HashMap<Integer, List<Prenda>>();
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda){
        compartimientos.put(++ultimaClave, listaDePrenda);
        return ultimaClave;
    }

    public void mostrarPrendas(){
        System.out.println("*** MOSTRAR PRENDAS ***");
        //System.out.println(this.compartimientos);
        compartimientos.forEach((c,v)-> System.out.println("Clave: "+c +" - Prendas: " + v));
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.compartimientos.get(numero);
    }

}
