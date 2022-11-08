package repository;

import java.util.List;

public interface CRUDRepository <T>{

    public void guardar(T obj);
    public void mostrarTodos();
    public T buscarPorId(Long id);
    public void eliminarPorId(Long id);
    public List<T> listarTodos();

}
