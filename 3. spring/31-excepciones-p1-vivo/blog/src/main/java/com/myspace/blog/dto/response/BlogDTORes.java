package com.myspace.blog.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class BlogDTORes {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;
}
