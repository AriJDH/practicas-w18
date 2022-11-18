package com.example.BE_java_hisp_w18_g04.repository;

import java.util.List;

public interface ICrudRepository <T,U>{
    T create(T t);
    List<T> findAll();
    T delete(U u);
    T findById(U u);
}
