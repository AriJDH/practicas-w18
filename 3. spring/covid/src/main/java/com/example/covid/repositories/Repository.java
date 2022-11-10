package com.example.covid.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository <T>{
    void add(T t);
    void remove(T t);
    void update(T t);
    Optional<T> find(T t);
    List<T> findAll();
    long count();
}
