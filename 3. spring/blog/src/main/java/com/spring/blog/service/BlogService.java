package com.spring.blog.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.blog.dto.EntradaBlogDtoReq;
import com.spring.blog.dto.EntradaBlogDtoRes;
import com.spring.blog.dto.IdDto;
import com.spring.blog.entity.EntradaBlog;
import com.spring.blog.exception.NotFoundException;
import com.spring.blog.repository.BlogRepository;
import com.spring.blog.repository.IBlogRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogService implements IBlogService {
    IBlogRepository blogRepository;

    public BlogService(BlogRepository blogRepository) {
        this.blogRepository = blogRepository;
    }

    @Override
    public IdDto addEntry(EntradaBlogDtoReq entry) {
        EntradaBlog newEntry = new EntradaBlog(1, entry.getTitle(), entry.getAuthor(), entry.getDate());
        return new IdDto(blogRepository.addEntry(newEntry));
    }

    @Override
    public List<EntradaBlogDtoRes> getAllEntries() {
        ObjectMapper op = new ObjectMapper();

        List<EntradaBlogDtoRes> entradasBlogDtoRes = blogRepository.getAllEntries().stream()
                .map(e -> op.convertValue(e, EntradaBlogDtoRes.class))
                .collect(Collectors.toList());
        if(entradasBlogDtoRes.size() == 0) throw new NotFoundException("No hay entradas");
        return entradasBlogDtoRes;
    }

    @Override
    public EntradaBlogDtoRes getEntryById(Integer id) {
        ObjectMapper op = new ObjectMapper();
        EntradaBlogDtoRes entradaBlogDtoRes = op.convertValue(blogRepository.getEntryById(id), EntradaBlogDtoRes.class);
        if(entradaBlogDtoRes == null) throw new NotFoundException("Entrada no encontrada");
        return entradaBlogDtoRes;
    }
}
