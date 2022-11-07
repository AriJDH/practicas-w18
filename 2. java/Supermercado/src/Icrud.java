import java.util.List;
import java.util.Optional;

public interface Icrud <T>{
    public void guardar(T obj,List<T> lista);
    public void borrar(T obj,List<T> lista);
    public boolean buscar(int id, List<T> lista);

}
