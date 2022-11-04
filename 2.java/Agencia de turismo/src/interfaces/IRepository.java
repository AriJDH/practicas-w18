package interfaces;

public interface IRepository<T> {
    boolean create();
    T getById();
    T getAll();
    boolean delete(T t);

}
