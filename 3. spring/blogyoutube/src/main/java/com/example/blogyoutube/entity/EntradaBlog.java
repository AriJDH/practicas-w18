package com.example.blogyoutube.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;

    public EntradaBlog(String titulo, String autor, LocalDate fechaPublicacion) {
        this.titulo = titulo;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
    }
}


