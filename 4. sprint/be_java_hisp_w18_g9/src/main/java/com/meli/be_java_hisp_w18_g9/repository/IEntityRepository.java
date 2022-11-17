package com.meli.be_java_hisp_w18_g9.repository;

import java.util.List;
import java.util.Optional;

public interface IEntityRepository <T>{
    List<T> findAll();
    Optional<T> findById(Integer id);
    T save(T entity);
    void deleteById(Integer id);
    Integer update(T entity);
}
