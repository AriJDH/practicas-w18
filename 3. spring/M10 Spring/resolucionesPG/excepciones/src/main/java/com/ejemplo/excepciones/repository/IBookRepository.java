package com.ejemplo.excepciones.repository;

import com.ejemplo.excepciones.model.Book;

import java.util.List;

public interface IBookRepository {

    public List<Book> traerTodos();
    public Book findById(Long id);

}
