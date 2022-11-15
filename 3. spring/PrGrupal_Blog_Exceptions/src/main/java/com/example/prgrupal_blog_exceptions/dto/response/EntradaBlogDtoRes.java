package com.example.prgrupal_blog_exceptions.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlogDtoRes {
    private String id;
    private String titulo;
    private String autor;
    private LocalDate fechaPublicacion;
}
