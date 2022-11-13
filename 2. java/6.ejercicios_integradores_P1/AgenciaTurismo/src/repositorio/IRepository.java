package repositorio;

import modelo.Cliente;

import java.util.Set;

public interface IRepository<T> {
    void add(T t);
    Set<T> getAll();
    T getOne(Long id);

}
