package Deportistas.Repository;

import java.util.List;

public interface IRepository<T> {
    public List<T> listarTodos();
    public void agregar(T t);
}
