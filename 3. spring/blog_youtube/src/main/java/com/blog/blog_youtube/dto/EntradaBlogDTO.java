package com.blog.blog_youtube.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EntradaBlogDTO {

    private Long idBlog;

    private String tituloBlog;

    private String nombreAutor;

    private LocalDate fechaPublicacion;
}
