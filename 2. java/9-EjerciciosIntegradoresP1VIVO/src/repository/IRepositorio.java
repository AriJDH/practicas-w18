package repository;

import java.util.List;

public interface IRepositorio<T> {

   void agregar(T t);
   List<T> buscarTodos();
   T buscarId(Long id);
   void eliminar(Long id);

}
