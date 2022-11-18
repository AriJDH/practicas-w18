package com.example.blog.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    private long id;
    private String titulo;
    private String nombreAutor;
    private LocalDate fechaPublicacion;
}
