package com.jcundere.ejerciciopractico08.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogRequest {

    private Integer id;
    private String titulo;
    private String nombreDeAutor;
    private String fechaDePublicacion;

}
