package com.youtuber.youtubeexcepciones.service;

import com.youtuber.youtubeexcepciones.DTO.EntradaBlogDTO;
import com.youtuber.youtubeexcepciones.Repositorio.IRepo;
import com.youtuber.youtubeexcepciones.model.EntradaBlog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceEntradas implements IService{
    @Autowired
    private IRepo repo;

    @Override
    public EntradaBlogDTO getEntradaBlogDTO(int id) {
        EntradaBlog entrada = repo.getEntradaBlog(id);

        EntradaBlogDTO entradaDTO = new EntradaBlogDTO(entrada.getId(), entrada.getTitle(),
                entrada.getNameAuthor(), entrada.getPublicDate());

        return entradaDTO;
    }

    @Override
    public List<EntradaBlogDTO> getAllEntradaDTOBlogs() {

        return repo.getAllEntradaBlogs().stream().map(e -> new EntradaBlogDTO(e.getId(),e.getTitle(),e.getNameAuthor(),
                e.getPublicDate())).collect(Collectors.toList());
    }

    @Override
    public void createEntradaBlogDTO(EntradaBlogDTO entradaDTO) {
        EntradaBlog entrada = new EntradaBlog();
        entrada.setId(entradaDTO.getId());
        entrada.setTitle(entradaDTO.getTitle());
        entrada.setNameAuthor(entradaDTO.getNameAuthor());
        entrada.setPublicDate(entradaDTO.getPublicDate());

        repo.createEntradaBlog(entrada);
    }
}
