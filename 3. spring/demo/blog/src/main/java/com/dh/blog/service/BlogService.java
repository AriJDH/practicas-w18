package com.dh.blog.service;

import com.dh.blog.dto.EntradaBlogDTO;
import com.dh.blog.entity.EntradaBlog;
import com.dh.blog.exception.BlogEntryNotFoundException;
import com.dh.blog.exception.BlogEntryRepeatedException;
import com.dh.blog.repository.BlogRepository;
import com.dh.blog.repository.IBlogRepository;
import com.dh.blog.util.MapperSingleton;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {

    private final IBlogRepository blogRepository;

    public BlogService(IBlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public void addBlogEntry(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entradaBlog = MapperSingleton.getInstance().map(entradaBlogDTO, EntradaBlog.class);
        if (entradaBlog.getId() == null)
            throw new IllegalArgumentException("Id no puede ser null.");

        if (blogRepository.hasId(entradaBlogDTO.getId()))
            throw new BlogEntryRepeatedException("Id duplicado.");

        blogRepository.addBlog(entradaBlog);
    }

    @Override
    public EntradaBlogDTO findBlogById(Integer id) {
        EntradaBlog entradaBlog = blogRepository.findBlogById(id);
        if (entradaBlog == null)
            throw new BlogEntryNotFoundException("Id ingresado no corresponde a ninguna entrada de Blog.");
        EntradaBlogDTO entradaBlogDTO = MapperSingleton.getInstance().map(entradaBlog, EntradaBlogDTO.class);
        return entradaBlogDTO;
    }

    @Override
    public List<EntradaBlogDTO> findBlogEntries() {
        List<EntradaBlogDTO> entradasBlog = blogRepository.findBlogs()
                .stream()
                .map(b -> MapperSingleton.getInstance().map(b, EntradaBlogDTO.class))
                .collect(Collectors.toList());

        return entradasBlog;
    }
}
