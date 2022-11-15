package com.example.practicablogexcepciones.service;

import com.example.practicablogexcepciones.dto.request.EntradaBlogDto;
import com.example.practicablogexcepciones.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogService {

    EntradaBlogDto findOne(Long id);
    List<EntradaBlogDto> findAll();

    void add(EntradaBlogDto entradaBlogDto);
}
