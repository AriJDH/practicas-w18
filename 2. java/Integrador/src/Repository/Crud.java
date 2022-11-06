package Repository;

public interface Crud<T> {
    void create(T t);
    void findAll();
    void deleteOne(String dni);
    void findOne(String dni);
}
