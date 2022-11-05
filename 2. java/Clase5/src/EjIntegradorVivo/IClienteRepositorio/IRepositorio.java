package EjIntegradorVivo.IClienteRepositorio;

import java.util.ArrayList;
import java.util.List;

public interface IRepositorio<T> {
    Long create(T t);
    T findOne(long id);
    List<T> findAll();
    void delete(long id);
    T update(T t);
}
