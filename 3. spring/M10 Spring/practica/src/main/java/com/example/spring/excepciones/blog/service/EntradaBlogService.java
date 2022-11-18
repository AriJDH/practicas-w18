package com.example.spring.excepciones.blog.service;

import com.example.spring.excepciones.blog.entity.EntradaBlog;
import com.example.spring.excepciones.blog.exception.IdNotExistExcep;
import com.fasterxml.jackson.databind.DeserializationFeature;

public class EntradaBlogService implements IEntradaBlogService {

/*
    @Override
    public entradaBlogDto findById(Integer id){
        return convertToDto(entradaBlogRepository.findById(id))
                .orElseThrow(()-> new IdNotExistExcep("Id no existe"));
    }

    private EntradaBlog convertToEntity(EntradaBlogDto entradaBlogDto){
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //TODO
    }*/

}
