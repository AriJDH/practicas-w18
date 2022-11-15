package com.youtuber.youtubeexcepciones.Repositorio;

import com.youtuber.youtubeexcepciones.DTO.EntradaBlogDTO;
import com.youtuber.youtubeexcepciones.model.EntradaBlog;

import java.util.List;

public interface IRepo {

    EntradaBlog getEntradaBlog(int id);

    List<EntradaBlog> getAllEntradaBlogs();

    void createEntradaBlog(EntradaBlog entrada);

}
