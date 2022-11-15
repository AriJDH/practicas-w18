package com.example.practicablogexcepciones.repository;

import com.example.practicablogexcepciones.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository {

    private List<EntradaBlog> entradasBlog;

    public EntradaBlogRepositoryImp() {
        this.entradasBlog = new ArrayList<>();
    }

    @Override
    public EntradaBlog findOne(Long id) {
        return this.entradasBlog.stream().filter(i -> i.getId() == id).findFirst().get();
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
