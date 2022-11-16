package com.example.blogyoutube.repository;

import com.example.blogyoutube.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository{

    private Map<Integer, EntradaBlog> blogs;

    public EntradaBlogRepositoryImp() {
        this.blogs = new HashMap<>();
    }

    @Override
    public EntradaBlog save(EntradaBlog blog) {
        Integer id = blogs.size()+1;
        blog.setId(id);
        blogs.put(id, blog);

        return blogs.get(id);
    }

    @Override
    public EntradaBlog findById(Integer id) {
        return blogs.get(id);
    }

    @Override
    public Map<Integer, EntradaBlog> findAll() {
        return blogs;
    }
}
