package com.example.demo.interfaces;

import java.util.List;
import java.util.Optional;

public interface CrudRepository<T> {
    public void guardar(T objeto);
    public List<T> buscar (String nombre);
    public List<T> listar();

}
