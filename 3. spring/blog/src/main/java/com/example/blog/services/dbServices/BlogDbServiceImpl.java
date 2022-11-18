package com.example.blog.services.dbServices;

import com.example.blog.entities.Blog;
import com.example.blog.exceptions.EntityAlreadyExistsException;
import com.example.blog.exceptions.EntityNotFoundException;
import com.example.blog.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogDbServiceImpl implements BlogDbService {
    @Autowired
    private BlogRepository blogRepository;

    @Override
    public Blog findById(long id) {
        return blogRepository.findById(id).orElseThrow(() -> {
            throw new EntityNotFoundException("El blog " + id + " no existe");
        });
    }

    @Override
    public void add(Blog blog) {
        long id = blog.getId();
        if(blogRepository.findById(id).isPresent())
            throw new EntityAlreadyExistsException("El blog "+ id + " ya existe.");
        blogRepository.add(blog);
    }

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }
}

