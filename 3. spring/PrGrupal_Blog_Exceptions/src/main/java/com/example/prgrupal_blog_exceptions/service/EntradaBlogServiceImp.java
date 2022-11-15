package com.example.prgrupal_blog_exceptions.service;

import com.example.prgrupal_blog_exceptions.dto.request.EntradaBlogDtoReq;
import com.example.prgrupal_blog_exceptions.dto.response.EntradaBlogDtoRes;
import com.example.prgrupal_blog_exceptions.entity.EntradaBlog;
import com.example.prgrupal_blog_exceptions.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService{

    @Autowired
    private IEntradaBlogRepository repo;

    @Override
    public String crearEntradaBlog(EntradaBlogDtoReq e) {
        EntradaBlog ent = new EntradaBlog(e.getId(), e.getTitulo(), e.getAutor());
        EntradaBlog res = this.repo.crearEntradaBlog(ent);

        try{
            return res.getId();
        }catch(Exception e){

        }

    }

    @Override
    public EntradaBlogDtoRes obtenerEntradaBlog(String id) {
        return null;
    }

    @Override
    public List<EntradaBlogDtoRes> obtenerTodasLasEntradas() {
        return null;
    }
}
