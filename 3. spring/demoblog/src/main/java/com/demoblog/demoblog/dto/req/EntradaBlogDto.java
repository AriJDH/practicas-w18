package com.demoblog.demoblog.dto.req;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EntradaBlogDto {
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
