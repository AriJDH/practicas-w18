package com.example.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class EntradaBlog {
    private String id;
    private String tituloDelBlog;
    private String nombreAutor;
    private String fechaPublicacion;


}
