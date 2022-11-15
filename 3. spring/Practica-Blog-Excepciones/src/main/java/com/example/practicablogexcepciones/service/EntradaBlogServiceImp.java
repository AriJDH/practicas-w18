package com.example.practicablogexcepciones.service;

import com.example.practicablogexcepciones.dto.request.EntradaBlogDto;
import com.example.practicablogexcepciones.entity.EntradaBlog;
import com.example.practicablogexcepciones.repository.EntradaBlogRepositoryImp;
import com.example.practicablogexcepciones.repository.IEntradaBlogRepository;
import org.springframework.stereotype.Service;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService
{


    private final IEntradaBlogRepository repository;

    public EntradaBlogServiceImp(IEntradaBlogRepository repository){
        this.repository = repository;
    }

    public EntradaBlog mapper2EntradaBlog(EntradaBlogDto entradaBlogDto){

        return new EntradaBlog(entradaBlogDto.getId(), entradaBlogDto.getTitulo(), entradaBlogDto.getAutor(), entradaBlogDto.getFechaPublicacion());
    }

    public EntradaBlogDto mapper2EntradaBlogDto(EntradaBlog entradaBlog){

        return new EntradaBlogDto(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getAutor(), entradaBlog.getFechaPublicacion());
    }

    @Override
    public void crearEntradaBlog(EntradaBlogDto entradaBlogDto){
        EntradaBlog entradaBlog = mapper2EntradaBlog(entradaBlogDto);
        repository.add(entradaBlog);
    }

    @Override
    public boolean existeEntradaBlog(Long id){

        EntradaBlog entradaBlog = repository.findOne(id);
        if(entradaBlog == null){
            return false;
        }
        return true;
    }





}
