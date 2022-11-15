package com.example.practicablogexcepciones.service;

import com.example.practicablogexcepciones.dto.request.EntradaBlogDto;

public interface IEntradaBlogService {

    void crearEntradaBlog(EntradaBlogDto entradaBlogDto);
    boolean existeEntradaBlog(Long id);

}
