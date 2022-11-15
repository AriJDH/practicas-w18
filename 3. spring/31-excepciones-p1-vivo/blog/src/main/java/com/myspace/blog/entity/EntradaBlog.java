package com.myspace.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;
}
