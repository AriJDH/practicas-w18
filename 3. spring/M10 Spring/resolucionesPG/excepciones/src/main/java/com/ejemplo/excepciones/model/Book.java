package com.ejemplo.excepciones.model;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Book {
    
    private Long id;
    private String title;
    private String author;

    public Book(Long id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }
  
}
