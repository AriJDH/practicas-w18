package com.myspace.blog.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.myspace.blog.dto.request.EntradaBlogDTOReq;
import com.myspace.blog.dto.response.BlogDTORes;
import com.myspace.blog.dto.response.CreadoDTORes;
import com.myspace.blog.entity.EntradaBlog;
import com.myspace.blog.exception.DuplicateIdException;
import com.myspace.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public ResponseEntity<CreadoDTORes> addBlog(EntradaBlogDTOReq entradaBlogDTOReq) {
        EntradaBlog entradaBlog = new EntradaBlog(
                entradaBlogDTOReq.getId(),
                entradaBlogDTOReq.getTitulo(),
                entradaBlogDTOReq.getAutor(),
                entradaBlogDTOReq.getFecha());

        if (!blogRepository.addBlog(entradaBlog)) {
            throw new DuplicateIdException("Duplicate ID >:/");
        }
        CreadoDTORes creadoDTORes = new CreadoDTORes("Todo bien, adelante", entradaBlog.getId());
        return new ResponseEntity<>(creadoDTORes, HttpStatus.CREATED);
    }

    @Override
    public BlogDTORes getBlogById(int id) {
        return new ObjectMapper().convertValue(blogRepository.getBlogById(id), new TypeReference<>() {});
    }

    @Override
    public List<BlogDTORes> getAllBlogs() {
        return new ObjectMapper().convertValue(blogRepository.getAll(), new TypeReference<>() {});
    }
}
