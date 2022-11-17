package com.meli.springmanejoexcepcionesp1vivo.service;

import com.meli.springmanejoexcepcionesp1vivo.dto.request.BlogDto;
import com.meli.springmanejoexcepcionesp1vivo.dto.response.BlogCreateDto;
import com.meli.springmanejoexcepcionesp1vivo.dto.response.BlogGetDto;

import java.util.List;

public interface IBlogService {
    BlogGetDto getBlog(Integer id);
    BlogCreateDto createBlog(BlogDto blog);
    List<BlogGetDto> getAllBlog();
}
