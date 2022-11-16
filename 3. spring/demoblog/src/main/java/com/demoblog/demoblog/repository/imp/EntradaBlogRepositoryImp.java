package com.demoblog.demoblog.repository.imp;

import com.demoblog.demoblog.entity.EntradaBlog;
import com.demoblog.demoblog.repository.IEntradaBlogRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository {

    List<EntradaBlog> entradaBlogs = new ArrayList<>();


    @Override
    public EntradaBlog crearEntradaBlog(EntradaBlog entradaBlog) {

        entradaBlogs.add(entradaBlog);
        return findById(entradaBlog.getId()).get();
    }

    @Override
    public Optional<EntradaBlog> findById(Integer id) {

        return entradaBlogs.stream()
                .filter(entradaBlog -> entradaBlog.getId().equals(id))
                .findFirst();
    }
}
