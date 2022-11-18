package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogEntryDTO;

public interface IBlogService {
    void addEntryBlog(BlogEntryDTO entradaBlog);
    BlogEntryDTO findById(Long id);
}
