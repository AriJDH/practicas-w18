package repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {
    public void create(T object);
    public void mostrarPorPantalla();
    public Optional<T> getById(String id);
    public void delete(String id);
    public List<T> getAll();
}
