package com.example.Blog.service;

import com.example.Blog.dto.EntradaBlogDtoRequest;
import com.example.Blog.dto.EntradaBlogDtoResponse;
import com.example.Blog.dto.EntradaBlogIdDtoResponse;
import com.example.Blog.entity.EntradaBlog;
import com.example.Blog.exception.EntradaBlogFoundException;
import com.example.Blog.exception.EntradaBlogNotFoundException;
import com.example.Blog.repository.IEntradaBlogRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EntradaBlogsServiceImp implements IEntradaBlogService{
    static ObjectMapper mapper = new ObjectMapper();
    private IEntradaBlogRepository entradaBlogRepository;

    public EntradaBlogsServiceImp(IEntradaBlogRepository entradaBlogRepository) {
        this.entradaBlogRepository = entradaBlogRepository;
    }

    @Override
    public EntradaBlogDtoResponse agregarBlog(EntradaBlogDtoRequest blog) {

        EntradaBlog newBlog = mapper.convertValue(blog, EntradaBlog.class);
        EntradaBlog entradaBlog = entradaBlogRepository.agregarBlog(newBlog);
        if (entradaBlog == null){
            throw new EntradaBlogFoundException("imposible crear blog con id " + blog.getId());
        }
        return new EntradaBlogDtoResponse(blog.getId());
    }

    @Override
    public EntradaBlogIdDtoResponse buscarBlog(Long id) {
        mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        EntradaBlog entradaBlog = entradaBlogRepository.buscarBlog(id);
        if (entradaBlog == null){
            throw new EntradaBlogNotFoundException(("blog con id " +id + " no fue encontrado"));
        }
        return mapper.convertValue(entradaBlog, EntradaBlogIdDtoResponse.class);
    }

    @Override
    public List<EntradaBlogIdDtoResponse> buscarTodos() {
        List<EntradaBlogIdDtoResponse> blogList = new ArrayList<>();
        mapper = mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        List<EntradaBlog> blogs = entradaBlogRepository.buscarTodos();
        blogs.stream().forEach(blog ->
                blogList.add(
                        mapper.convertValue(blog, EntradaBlogIdDtoResponse.class
                        )
                )
        );
        return blogList;
    }
}
