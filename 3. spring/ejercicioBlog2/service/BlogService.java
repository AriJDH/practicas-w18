package com.mercadolibre.blog.service;

import com.mercadolibre.blog.dto.BlogEntryDTO;
import com.mercadolibre.blog.entity.BlogEntry;
import com.mercadolibre.blog.repository.BlogRepository;
import com.mercadolibre.blog.repository.IBlogRepository;
import com.mercadolibre.blog.util.Utils;
import org.springframework.stereotype.Service;

@Service
public class BlogService implements IBlogService {
    IBlogRepository blogRespository;

    public BlogService(BlogRepository blogRespository) {
        this.blogRespository = blogRespository;
    }

    @Override
    public void addEntryBlog(BlogEntryDTO entradaBlog) {
        BlogEntry entradaBlogEntity = Utils.MAPPER.convertValue(entradaBlog, BlogEntry.class);
        blogRespository.addEntryBlog(entradaBlogEntity);
    }

    @Override
    public BlogEntryDTO findById(Long id) {
        BlogEntry entradaBlogEntity = blogRespository.findById(id);
        BlogEntryDTO entradaBlog = Utils.MAPPER.convertValue(entradaBlogEntity, BlogEntryDTO.class);
        return entradaBlog;
    }
}
