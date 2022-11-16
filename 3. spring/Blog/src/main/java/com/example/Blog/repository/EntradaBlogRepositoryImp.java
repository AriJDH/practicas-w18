package com.example.Blog.repository;

import com.example.Blog.entity.EntradaBlog;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@AllArgsConstructor
@Repository
public class EntradaBlogRepositoryImp implements IEntradaBlogRepository {
    private HashMap<Long,EntradaBlog> blogs;

    @Override
    public EntradaBlog agregarBlog(EntradaBlog blog) {
        if (blogs.size() > 0) {
            if (buscarBlog(blog.getId()) != null) {
                return null;
            }
        }
        blogs.put(blog.getId() ,blog);
        return blog;
    }

    @Override
    public EntradaBlog buscarBlog(Long id) {
        EntradaBlog blog = blogs.get(id);
        return blog;
    }

    @Override
    public List<EntradaBlog> buscarTodos() {
        List<EntradaBlog> blogsResp = new ArrayList<>();
        blogs.forEach((k,v) -> blogsResp.add(v));
        return blogsResp;
    }
}
