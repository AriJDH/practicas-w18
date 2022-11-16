package com.example.excepciones.repository;

import com.example.excepciones.entity.Book;

import java.util.List;

public interface IBookRepository {

    public List<Book> traerTodos();
    public Book findById(Long id);
}
