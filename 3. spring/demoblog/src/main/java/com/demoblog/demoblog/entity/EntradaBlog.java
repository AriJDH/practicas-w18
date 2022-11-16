package com.demoblog.demoblog.entity;


import lombok.Data;

@Data
public class EntradaBlog {
    private Integer id=0;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;

    public EntradaBlog(){
        this.id += 1;
    }
}
