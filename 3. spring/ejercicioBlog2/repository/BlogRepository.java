package com.mercadolibre.blog.repository;
import com.mercadolibre.blog.entity.BlogEntry;
import com.mercadolibre.blog.exception.AlreadyExistsException;
import com.mercadolibre.blog.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BlogRepository implements IBlogRepository{
    private Map<Long, BlogEntry> database = new HashMap<>();

    @Override
    public void addEntryBlog(BlogEntry entradaBlog) {
        if (this.existsById(entradaBlog.getId()))
            throw new AlreadyExistsException("El recurso ya existe.");
        database.put(entradaBlog.getId(), entradaBlog);
    }

    @Override
    public BlogEntry findById(Long id) {
        if (!this.existsById(id)) {
            throw new NotFoundException("No encontrado");
        }
        return this.database.get(id);
    }

    @Override
    public boolean existsById(Long id) {
        return this.database.containsKey(id);
    }

}
