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
        EntradaBlog yaExiste = this.entradas.stream().filter(b -> b.getId().equals(e.getId())).findFirst().orElse(null);

        if(yaExiste == null){
            this.entradas.add(e);
            return e;
        }else{
            return null;
        }
    }

    @Override
    public EntradaBlog obtenerEntradaBlog(String id) {
        return this.entradas.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<EntradaBlog> obtenerTodasLasEntradas() {
        return this.entradas;
    }
}
