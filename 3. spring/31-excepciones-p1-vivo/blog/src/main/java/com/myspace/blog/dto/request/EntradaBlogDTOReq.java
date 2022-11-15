package com.myspace.blog.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EntradaBlogDTOReq {
    private int id;
    private String titulo;
    private String autor;
    private String fecha;
}
