package Repositorio;

import java.util.List;
import java.util.Optional;

public interface CRUD <T>{

    public void guardar (T objeto);
    public void imprimir();
    public Optional<T> buscar (int id);
    public void eliminar (int id);
    public List<T> traerTodos();
}
