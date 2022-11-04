package clase4_b_EjerciciosIntegrador.repositorio;

import java.util.Set;

public interface IRepository<T> {
    void add(T t);
    Set<T> getAll();
    T getOne();
}
