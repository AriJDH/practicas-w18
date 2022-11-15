package com.bootcamp.blog.services;

import com.bootcamp.blog.dto.request.BlogDtoRequest;
import com.bootcamp.blog.dto.response.BlogDtoResponse;

import java.util.List;

public interface IBlogService {
    void creaBlog(BlogDtoRequest blogDtoRequest);
    Boolean existeId(Integer idBlog);
    List<BlogDtoResponse> findById(Integer id);
    List<BlogDtoResponse> getAllBlog();
}
