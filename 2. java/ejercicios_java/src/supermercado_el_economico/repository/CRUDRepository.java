package supermercado_el_economico.repository;

import java.util.Optional;

public interface CRUDRepository <T> {

    public void save (T objeto);
    public void mostrarTodo();
    public Optional<T> buscar (Long id);
    public void eliminar (Long id);
}
