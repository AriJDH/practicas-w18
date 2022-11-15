package com.blog.blog_youtube.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
public class EntradaBlogInDTO {

    private Long idBlog;

    private String tituloBlog;

    private String nombreAutor;

    private LocalDate fechaPublicacion;
}
