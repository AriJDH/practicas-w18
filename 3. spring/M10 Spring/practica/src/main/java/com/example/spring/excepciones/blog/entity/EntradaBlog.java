package com.example.spring.excepciones.blog.entity;

import lombok.*;

import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EntradaBlog {
    private Integer Id;
    private String tituloBlog;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
