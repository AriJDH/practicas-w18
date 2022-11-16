package com.blog.blog_youtube.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {

    private Long idBlog;

    private String tituloBlog;

    private String nombreAutor;

    private LocalDate fechaPublicacion;
}
