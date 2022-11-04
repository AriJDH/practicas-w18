import java.util.List;
import java.util.Map;

public class GuardaRopa {
    protected Map<Integer, List<Prenda>> guardaRopa;
    protected Integer id;

    public Map<Integer, List<Prenda>> getGuardaRopa() {
        return guardaRopa;
    }

    public void setGuardaRopa(Map<Integer, List<Prenda>> guardaRopa) {
        this.guardaRopa = guardaRopa;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        if (!this.guardaRopa.isEmpty())
            this.id = this.guardaRopa.size() -1;
        else
            this.id = 0;
        this.guardaRopa.put(this.id,listaDePrenda);
        return this.id;
    }

    @Override
    public String toString() {
        return "GuardaRopa{" +
                "guardaRopa=" + guardaRopa +
                ", id=" + id +
                '}';
    }

    public GuardaRopa(Map<Integer, List<Prenda>> guardaRopa, Integer id) {
        this.guardaRopa = guardaRopa;
        this.id = id;
    }

    public void mostrarPrendas(){
        System.out.println("El guardaropa contiene las siguientes prendas: ");
        for (Map.Entry<Integer,List<Prenda>>g:guardaRopa.entrySet()){
            System.out.println(g.getKey() + " " + g.getValue());
        }
    }

    public List<Prenda> devolverPrendas(Integer numero){
        return this.guardaRopa.get(numero);
    }

}
