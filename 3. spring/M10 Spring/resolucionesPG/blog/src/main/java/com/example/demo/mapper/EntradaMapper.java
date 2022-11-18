package com.example.demo.mapper;

import com.example.demo.dtos.EntradaBlogDTO;
import com.example.demo.model.EntradaBlog;
import org.springframework.stereotype.Component;

@Component
public class EntradaMapper {

    public EntradaBlog entradaBlogDTOToEntradaBlog(EntradaBlogDTO entradaBlogDTO){
        EntradaBlog entradaBlog = new EntradaBlog();
        entradaBlog.setId(entradaBlogDTO.getId());
        entradaBlog.setAutor(entradaBlogDTO.getAutor());
        entradaBlog.setFecha(entradaBlogDTO.getFecha());
        entradaBlog.setTitulo(entradaBlogDTO.getTitulo());
        return entradaBlog;
    }

    public EntradaBlogDTO entradaBlogToEntradaBlogDTO(EntradaBlog entradaBlog){
        EntradaBlogDTO entradaBlogDTO = new EntradaBlogDTO();
        entradaBlogDTO.setId(entradaBlog.getId());
        entradaBlogDTO.setAutor(entradaBlog.getAutor());
        entradaBlogDTO.setFecha(entradaBlog.getFecha());
        entradaBlogDTO.setTitulo(entradaBlog.getTitulo());
        return entradaBlogDTO;
    }
}
