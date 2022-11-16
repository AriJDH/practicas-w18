package com.example.Blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlog {
    private long id;
    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;
}
