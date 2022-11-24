package com.jcundere.ejerciciopractico06.repository;

import java.util.List;

public interface IPersonajeRepository<T> {

    public void save(T entity);
    public void saveAll(List<T> entityList);
    public List<T> searchByName(String name);
    public List<T> getAll();

}