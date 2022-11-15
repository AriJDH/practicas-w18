package com.youtuber.youtubeexcepciones.service;

import com.youtuber.youtubeexcepciones.DTO.EntradaBlogDTO;
import com.youtuber.youtubeexcepciones.model.EntradaBlog;

import java.util.List;

public interface IService {

    EntradaBlogDTO getEntradaBlogDTO(int id);

    List<EntradaBlogDTO> getAllEntradaDTOBlogs();

    void createEntradaBlogDTO(EntradaBlogDTO entradaDTO);
}
