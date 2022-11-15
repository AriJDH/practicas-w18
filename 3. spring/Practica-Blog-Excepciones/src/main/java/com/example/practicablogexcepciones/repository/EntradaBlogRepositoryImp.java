package com.example.practicablogexcepciones.repository;

import com.example.practicablogexcepciones.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository {

    private List<EntradaBlog> entradasBlog;

    public EntradaBlogRepositoryImp() {
        this.entradasBlog = new ArrayList<>();
        //this.entradasBlog.add(new EntradaBlog(1,"Probando","Jonathan Caucota", new Date(10/02/2022)));
    }

    @Override
    public EntradaBlog findOne(Long id) {
        EntradaBlog entradaBuscada = null;
        int i = 0;
        while(i < this.entradasBlog.size() && entradaBuscada == null){
            if(this.entradasBlog.get(i).getId() == id){
                entradaBuscada = this.entradasBlog.get(i);
            }
            i++;
        }
        return entradaBuscada;
    }

    @Override
    public List<EntradaBlog> findAll() {
        return this.entradasBlog;
    }

    @Override
    public void add(EntradaBlog entradaBlog) {
        this.entradasBlog.add(entradaBlog);
    }
}
