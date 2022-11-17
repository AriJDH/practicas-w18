package com.meli.springmanejoexcepcionesp1vivo.service;

import com.meli.springmanejoexcepcionesp1vivo.dto.request.BlogDto;
import com.meli.springmanejoexcepcionesp1vivo.dto.response.BlogCreateDto;
import com.meli.springmanejoexcepcionesp1vivo.dto.response.BlogGetDto;
import com.meli.springmanejoexcepcionesp1vivo.entity.Blog;
import com.meli.springmanejoexcepcionesp1vivo.exception.BlogExistException;
import com.meli.springmanejoexcepcionesp1vivo.exception.BlogNoExistException;
import com.meli.springmanejoexcepcionesp1vivo.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlogServiceImp implements IBlogService {

    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public BlogCreateDto createBlog(BlogDto blog) {
        var x = iBlogRepository.createBlog(new Blog(blog.getId(), blog.getTitle(), blog.getAutor(), blog.getPublicationDate()));
        if (x == null) throw new BlogExistException("Ya existe un blog con id " + blog.getId());
        return new BlogCreateDto(blog.getId());
    }

    @Override
    public BlogGetDto getBlog(Integer id) {
        var blog = iBlogRepository.selectBlog(id);
        if (blog==null) throw new BlogNoExistException("No existe un blog con id " + id);
        return new BlogGetDto(blog.getId(), blog.getTitle(), blog.getAutor(), blog.getPublicationDate());
    }

    @Override
    public List<BlogGetDto> getAllBlog() {
        return iBlogRepository.getAllBlog().stream().
                map(blog -> new BlogGetDto(blog.getId(), blog.getTitle(), blog.getAutor(), blog.getPublicationDate())).
                collect(Collectors.toList());
    }
}
