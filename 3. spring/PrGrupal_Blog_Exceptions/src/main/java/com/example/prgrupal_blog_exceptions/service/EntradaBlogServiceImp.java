package com.example.prgrupal_blog_exceptions.service;

import com.example.prgrupal_blog_exceptions.dto.request.EntradaBlogDtoReq;
import com.example.prgrupal_blog_exceptions.dto.response.EntradaBlogDtoRes;
import com.example.prgrupal_blog_exceptions.entity.EntradaBlog;
import com.example.prgrupal_blog_exceptions.exception.AlreadyExistsExcepction;
import com.example.prgrupal_blog_exceptions.exception.NotFoundException;
import com.example.prgrupal_blog_exceptions.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService{

    @Autowired
    private IEntradaBlogRepository repo;

    @Override
    public String crearEntradaBlog(EntradaBlogDtoReq e) {
        EntradaBlog ent = new EntradaBlog(e.getId(), e.getTitulo(), e.getAutor());
        EntradaBlog res = this.repo.crearEntradaBlog(ent);

        if(res == null)throw new AlreadyExistsExcepction("Ya existe una entrada de blog con ese id.");

        return res.getId();
    }

    @Override
    public EntradaBlogDtoRes obtenerEntradaBlog(String id) {
        EntradaBlog ent = this.repo.obtenerEntradaBlog(id);

        if(ent == null)throw new NotFoundException("No se encontro la entrada de blog.");

        return new EntradaBlogDtoRes(ent.getId(), ent.getTitulo(), ent.getAutor(), ent.getFechaPublicacion());
    }

    @Override
    public List<EntradaBlogDtoRes> obtenerTodasLasEntradas() {
        List<EntradaBlog> ents = this.repo.obtenerTodasLasEntradas();
        List<EntradaBlogDtoRes> retorno = new ArrayList<EntradaBlogDtoRes>();

        for(EntradaBlog e: ents){
            retorno.add(new EntradaBlogDtoRes(e.getId(),e.getTitulo(),e.getAutor(),e.getFechaPublicacion()));
        }

        if(retorno.size() < 1)throw new NotFoundException("No se encontraron elementos.");

        return retorno;
    }
}
