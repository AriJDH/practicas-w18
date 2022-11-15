package com.example.blog.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

}
