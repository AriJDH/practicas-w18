package com.example.prgrupal_blog_exceptions.repository;

import com.example.prgrupal_blog_exceptions.entity.EntradaBlog;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository{

    List<EntradaBlog> entradas;

    public EntradaBlogRepositoryImp(){
        this.entradas = new ArrayList<EntradaBlog>();
        this.entradas.add(new EntradaBlog("EntradaExistente", "Prueba","PewDiePie"));
    }

    @Override
    public EntradaBlog crearEntradaBlog(EntradaBlog e) {
        return null;
    }

    @Override
    public EntradaBlog obtenerEntradaBlog(String id) {
        return null;
    }

    @Override
    public List<EntradaBlog> obtenerTodasLasEntradas() {
        return null;
    }
}
