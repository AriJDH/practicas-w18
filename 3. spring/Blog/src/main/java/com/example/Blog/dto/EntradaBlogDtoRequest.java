package com.example.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EntradaBlogDtoRequest {
    private long id;
    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;
}
