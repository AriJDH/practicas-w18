package com.jcundere.ejerciciopractico04.repository;

import java.util.List;
import java.util.Optional;

public interface CRUDRepository<T> {

    public void save(T objeto);

    public Optional<T> buscar(String nombre);

    public List<T> traeTodos();
}
