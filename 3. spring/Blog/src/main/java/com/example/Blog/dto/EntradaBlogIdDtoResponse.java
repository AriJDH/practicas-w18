package com.example.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EntradaBlogIdDtoResponse {

    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;

}
