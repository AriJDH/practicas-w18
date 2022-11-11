package clase4_b_EjerciciosIntegrador;

import java.util.List;
import java.util.Set;

public interface IRepositorio<T> {

    public void agregar(T t);
    public Set<T> traerTodos();

}
