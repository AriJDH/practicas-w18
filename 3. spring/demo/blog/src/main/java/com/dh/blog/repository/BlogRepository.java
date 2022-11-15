package com.dh.blog.repository;

import com.dh.blog.entity.EntradaBlog;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BlogRepository implements IBlogRepository{

    Map<Integer, EntradaBlog> entradasBlog = new HashMap<Integer, EntradaBlog>();

    @Override
    public EntradaBlog findBlogById(Integer id) {
        return entradasBlog.get(id);
    }

    @Override
    public void addBlog(EntradaBlog entradaBlog) {
        entradasBlog.put(entradaBlog.getId(), entradaBlog);
    }

    @Override
    public List<EntradaBlog> findBlogs() {
        return new ArrayList<>(entradasBlog.values());
    }

    @Override
    public boolean hasId(Integer id) {
        return entradasBlog.containsKey(id);
    }
}
