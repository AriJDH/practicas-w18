package com.ejemplo.excepciones.repository;

import com.ejemplo.excepciones.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepository implements IBookRepository {

    List<Book> listaBooks = new ArrayList<Book>() {{
        add(new Book(1L, "¿Cómo programar en Java?", "Luisina de Paula"));
        add(new Book(2L, "Servidores: ¿Cómo administrarlos?", "Gabriel Guismín"));
    }};

    @Override
    public List<Book> traerTodos () {
        return listaBooks;
    }

    @Override
    public Book findById (Long id) {
        for (Book book : listaBooks) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
    return null;
    }
  
}

