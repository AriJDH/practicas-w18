package Supermercado.Repositorio;

public interface IRepositorio <T>{
    T create(T t);
    T update(T t);
    T read(Long id);
    void delete(Long id);
}
