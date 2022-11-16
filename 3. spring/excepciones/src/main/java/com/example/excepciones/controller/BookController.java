package com.example.excepciones.controller;

import com.example.excepciones.entity.Book;
import com.example.excepciones.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    IBookService bookService;

    @GetMapping("/books")
    public List<Book> traerTodos(){
        return bookService.traerTodos();
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }
}
