package com.example.excepciones.service;

import com.example.excepciones.entity.Book;
import com.example.excepciones.exception.NotFoundException;
import com.example.excepciones.repository.BookRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements IBookService{

    @Autowired
    BookRepositoryImp bookRepository;

    @Override
    public List<Book> traerTodos() {
        return bookRepository.traerTodos();
    }

    @Override
    public Book findById(Long id) {
        Book libroEncontrado = bookRepository.findById(id);
        if (libroEncontrado == null){
            throw new NotFoundException("El libro con la id: " + id + " no fue encontrado.");
        }
        return libroEncontrado;
    }
}
