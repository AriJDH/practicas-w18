import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {
    //Atributos
    private Map<Integer, List<Prenda>> guardador;
    private int identificador;


    //Constructor inicial
    public GuardaRopa() {
        this.guardador=new HashMap<Integer, List<Prenda>>();
        this.identificador =0;

    }
    //Método para almacenar las prendas como lista
    public Integer guardaPrendas (List<Prenda> listaDePrenda){
        int identificar =guardador.size()+1;
        guardador.put(identificar,listaDePrenda);
        return identificar;

    }

    //Método para mostrar las prendas
    public void mostrarPrenda(){
        for (int clave: guardador.keySet()) {
            System.out.println("Identificador " + clave + " ");
            System.out.println(guardador.get(clave));
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return  guardador.get(numero);
    }

}


