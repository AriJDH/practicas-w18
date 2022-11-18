package com.ejemplo.excepciones.service;
import com.ejemplo.excepciones.model.Book;

import java.util.List;

public interface IBookService {

    public List<Book> traerTodos();
    public Book findById(Long id);


}
