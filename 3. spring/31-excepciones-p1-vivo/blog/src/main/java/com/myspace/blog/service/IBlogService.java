package com.myspace.blog.service;

import com.myspace.blog.dto.request.EntradaBlogDTOReq;
import com.myspace.blog.dto.response.BlogDTORes;
import com.myspace.blog.dto.response.CreadoDTORes;
import com.myspace.blog.entity.EntradaBlog;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IBlogService {
    ResponseEntity<CreadoDTORes> addBlog(EntradaBlogDTOReq entradaBlogDTOReq);
    BlogDTORes getBlogById(int id);
    List<BlogDTORes> getAllBlogs();
}

