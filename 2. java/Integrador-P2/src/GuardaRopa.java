import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRopa {

    private Map<Integer, List<Prenda>> listGuardarropa=new HashMap<>();
    private Integer id=0;



    public Integer guardarPrenda(List<Prenda> listaPrenda){
         listGuardarropa.put(id+=1,listaPrenda);
         return id;
    }

    public void mostrarPrenda(){
        listGuardarropa.forEach((id,prendas)-> System.out.println("id: "+id+prendas.toString()));
    }
    public List<Prenda> devolverPrendas(Integer numero){
       return listGuardarropa.get(numero);
    }

    public Map<Integer, List<Prenda>> getListGuardarropa() {
        return listGuardarropa;
    }

    public void setListGuardarropa(Map<Integer, List<Prenda>> listGuardarropa) {
        this.listGuardarropa = listGuardarropa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "listGuardarropa=" + listGuardarropa +
                ", id=" + id +
                '}';
    }
}
