package com.example.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
