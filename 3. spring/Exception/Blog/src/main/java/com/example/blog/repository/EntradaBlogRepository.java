package com.example.blog.repository;

import com.example.blog.dto.BlogDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EntradaBlogRepository implements IEntradaBlogRepository{

    private static List<BlogDTO> blogs;

    @Override
    public void agregarBlog(BlogDTO blog) {
        blogs.add(blog);
    }

    @Override
    public BlogDTO buscarBlogPorID(String id) {
        BlogDTO resultado = null;
        for(BlogDTO b : blogs){
            if(b.getId().equals(id)) resultado = b;
        }
        return resultado;
    }

    @Override
    public List<BlogDTO> devolverBlog() {
        return this.blogs;
    }

    /* USAR ENTIDADES Y NO DTO'S
}
