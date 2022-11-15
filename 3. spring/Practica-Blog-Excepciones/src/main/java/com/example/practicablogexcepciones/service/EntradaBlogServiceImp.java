package com.example.practicablogexcepciones.service;

import com.example.practicablogexcepciones.dto.request.EntradaBlogDto;
import com.example.practicablogexcepciones.entity.EntradaBlog;
import com.example.practicablogexcepciones.exception.NotFoundException;
import com.example.practicablogexcepciones.repository.EntradaBlogRepositoryImp;
import com.example.practicablogexcepciones.repository.IEntradaBlogRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.NotActiveException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService
{

    private IEntradaBlogRepository repository;

    public EntradaBlogServiceImp(){
        this.repository = new EntradaBlogRepositoryImp();
    }

    @Override
    public EntradaBlogDto findOne(Long id) {
        EntradaBlog entradaBuscada = null;
        EntradaBlogDto entradaBlogDto = null;
        int i = 0;
        List<EntradaBlog> entradasBlog = this.repository.findAll();

        while(i < entradasBlog.size() && entradaBuscada == null){
            if(entradasBlog.get(i).getId() == id){
                entradaBuscada = entradasBlog.get(i);
            }
            i++;
        }
        if(entradaBuscada != null){
            entradaBlogDto = new EntradaBlogDto(entradaBuscada.getId(), entradaBuscada.getTitulo(), entradaBuscada.getAutor(), entradaBuscada.getFechaPublicacion());
        }else{
            throw new NotFoundException("No se encontro una entrada con el id: " + id);
        }
        return entradaBlogDto;
    }

    @Override
    public List<EntradaBlogDto> findAll() {
        ObjectMapper op = new ObjectMapper();

        List<EntradaBlog> entradasBlog = this.repository.findAll();
        List<EntradaBlogDto> entradasBlogDto = entradasBlog.stream()
                .map(entradaBlog -> op.convertValue(entradaBlog, EntradaBlogDto.class)).collect(Collectors.toList());
        if(entradasBlogDto.size() == 0){
            throw new NotFoundException("No se encontraron entradas");
        }
        return entradasBlogDto;
    }

    @Override
    public void add(EntradaBlogDto entradaBlogDto) {
        if(existeEntrada(entradaBlogDto)){
            throw new NotFoundException("Ya existe una entrada con ID: " + entradaBlogDto.getId());
        }else{
            this.repository.add(new EntradaBlog(entradaBlogDto.getId(), entradaBlogDto.getTitulo(), entradaBlogDto.getAutor(), entradaBlogDto.getFechaPublicacion()));
        }

    }

    private boolean existeEntrada(EntradaBlogDto entradaBlogDto){
        boolean existe = false;
        for (EntradaBlog e:this.repository.findAll()) {
            if(e.getId() == entradaBlogDto.getId()){
                existe = true;
            }
        }
        return existe;
    }
}
