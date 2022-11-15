package com.example.prgrupal_blog_exceptions.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlogDtoReq {
    private String id;
    private String titulo;
    private String autor;
}
