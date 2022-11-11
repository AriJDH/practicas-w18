package com.example.demo.Interfaces;

import java.util.List;

public interface CrudRepository<T> {
    public List<T> getData();
    public T getData(String objeto);
}
