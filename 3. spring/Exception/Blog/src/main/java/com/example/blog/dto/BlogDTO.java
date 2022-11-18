package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    private String id;
    private String tituloDelBlog;
    private String nombreAutor;
    private String fechaPublicacion;
}
