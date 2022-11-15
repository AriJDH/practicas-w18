package com.blog.blog_youtube.repository;

import com.blog.blog_youtube.dto.EntradaBlogDTO;
import com.blog.blog_youtube.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BlogRepositoryImpl implements IBlogRepository {

    private List<EntradaBlog> entradaBlogList = new ArrayList<>();

    @Override
    public Long crearBlog(EntradaBlog entradaBlog) {

        entradaBlogList.add(entradaBlog);

        return entradaBlog.getIdBlog();
    }

    @Override
    public EntradaBlog consultarBlogPorId(Long id) {
        return entradaBlogList.stream().filter(x -> x.getIdBlog().equals(id)).findAny().orElse(null);
    }

    @Override
    public List<EntradaBlog> consultarBlogs() {
        return entradaBlogList;
    }
}
