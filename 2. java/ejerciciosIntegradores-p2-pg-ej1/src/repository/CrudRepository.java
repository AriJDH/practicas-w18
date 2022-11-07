package repository;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <T> {
    void create(T objectT);
    Optional<T> retrieve(int id);
    List<T> retrieveAll();
    void printAll();
    Boolean update(int id, T t);
    void delete(int id);
}
