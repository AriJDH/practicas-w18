package repository;

import java.util.List;

public interface IRepository <T>{
	
	T agregar(T t);
	T buscarPorId(Long id);
	List<T> buscarTodos();
	void eliminarPorId(Long id);
	
}
