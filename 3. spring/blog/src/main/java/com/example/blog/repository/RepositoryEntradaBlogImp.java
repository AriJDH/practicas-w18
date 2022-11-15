package com.example.blog.repository;

import com.example.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositoryEntradaBlogImp implements IRepositoryEntradaBlog{

    private List<EntradaBlog> entradaBlogList = new ArrayList<>();

    @Override
    public void add(EntradaBlog entrada) {
        entradaBlogList.add(entrada);
    }

    @Override
    public List<EntradaBlog> listAll() {
        return entradaBlogList;
    }

    @Override
    public EntradaBlog findById(Long id) {
        return entradaBlogList.stream().filter(x->x.getId().equals(id)).findFirst().orElse(null);
    }
}
