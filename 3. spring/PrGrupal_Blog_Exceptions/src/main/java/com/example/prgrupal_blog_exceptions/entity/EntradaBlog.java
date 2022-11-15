package com.example.prgrupal_blog_exceptions.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlog {
    private String id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public EntradaBlog(String id, String titulo, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = LocalDate.now();
    }
}
