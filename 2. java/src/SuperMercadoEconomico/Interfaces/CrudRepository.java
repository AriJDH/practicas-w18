package SuperMercadoEconomico.Interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    public void save(T objeto);
    public void mostrarPantalla();
    public Optional<T> buscar (Long id);
    public void eliminar(Long id);
    public List<T> traerTodos();
}
