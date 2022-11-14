package exercice_2.repository;

import java.util.List;
import java.util.Optional;

/**
 * CRUDRepository
 */
public interface CRUDRepository<T> {
  public void save(T object);

  public void show();

  public Optional<T> find(Long id);

  public void delete(Long id);

  public List<T> listAll(Long id);
}
