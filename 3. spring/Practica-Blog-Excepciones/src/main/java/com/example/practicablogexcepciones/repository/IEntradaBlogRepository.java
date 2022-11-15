package com.example.practicablogexcepciones.repository;


import com.example.practicablogexcepciones.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    EntradaBlog findOne(Long id);
    List<EntradaBlog> findAll();

    void add(EntradaBlog entradaBlog);
}
