package com.jcundere.ejerciciopractico08.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {

    private Integer id;
    private String titulo;
    private String nombreDeAutor;
    private String fechaDePublicacion;

}
