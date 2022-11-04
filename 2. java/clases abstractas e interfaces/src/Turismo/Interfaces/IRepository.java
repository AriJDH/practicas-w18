package Turismo.Interfaces;

public interface IRepository <T>{
    T create(T t);
    void delete(T t);
    T find(T t);
    T update(T anterior, T nuevo);
    Iterable<T> findAll();
}
