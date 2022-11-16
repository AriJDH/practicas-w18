package com.example.excepciones.service;

import com.example.excepciones.entity.Book;

import java.util.List;

public interface IBookService {

    public List<Book> traerTodos();
    public Book findById(Long id);
}
