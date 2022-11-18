package com.mercadolibre.blog.repository;

import com.mercadolibre.blog.entity.BlogEntry;

public interface IBlogRepository {
    void addEntryBlog(BlogEntry entradaBlog);
    BlogEntry findById(Long id);
    boolean existsById(Long id);
}
