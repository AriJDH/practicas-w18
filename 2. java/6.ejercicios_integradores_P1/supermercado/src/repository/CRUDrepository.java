package repository;

import model.Cliente;

import java.util.List;
import java.util.Optional;

public interface CRUDrepository<T> {
    public void save(Object obj);
    public void mostrar();
    public Optional<T> buscar (String dni);
    public void eliminar(String dni);
    public List<T> traerTodos();



}
