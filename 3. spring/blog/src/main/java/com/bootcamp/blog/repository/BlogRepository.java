package com.bootcamp.blog.repository;

import com.bootcamp.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Repository
public class BlogRepository implements IBlogRepository{
    public List<EntradaBlog> blogRepositories = new ArrayList<>();
    @Override
    public void addBlog(EntradaBlog entradaBlog){
        EntradaBlog entradaBlog1 = new EntradaBlog(entradaBlog.getId(), entradaBlog.getTitulo(), entradaBlog.getAutor(), entradaBlog.getFechaPublicacion());
        blogRepositories.add(entradaBlog1);
    }
    @Override
    public List<EntradaBlog> getAllBlogs(){
        return blogRepositories;
    }

    @Override
    public List<EntradaBlog> findById(Integer id) {
        return blogRepositories.stream()
                .filter(p-> p.getId()==id)
                .collect(Collectors.toList());
    }
}
