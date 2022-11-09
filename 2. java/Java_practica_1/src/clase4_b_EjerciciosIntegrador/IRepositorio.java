package clase4_b_EjerciciosIntegrador;

import java.util.List;

public interface IRepositorio<T> {

    public void agregar(T t);
    public List<T> listarTodos();

}
