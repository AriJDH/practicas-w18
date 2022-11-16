package com.example.excepciones.repository;

import com.example.excepciones.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRepositoryImp implements IBookRepository{

    List<Book> listaBooks = new ArrayList<>() {{
       add(new Book(1L, "¿Cómo programar en Java?", "Luisina de Paula"));
       add(new Book(2L, "Servidores: ¿Cómo administrarlos?", "Gabriel Guismin"));
    }};

    @Override
    public List<Book> traerTodos() {
        return listaBooks;
    }

    @Override
    public Book findById(Long id) {
        return listaBooks.stream().filter(m -> m.getId().equals(id)).findFirst().orElse(null);
    }
}
