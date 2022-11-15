package com.blog.blog_youtube.service;

import com.blog.blog_youtube.dto.EntradaBlogDTO;
import com.blog.blog_youtube.dto.EntradaBlogInDTO;
import com.blog.blog_youtube.dto.EntradaBlogOutDTO;

import java.util.List;

public interface IBlogService {

    EntradaBlogOutDTO crearBlog(EntradaBlogInDTO entradaBlogInDTO);

    EntradaBlogDTO consultarBlogPorId(Long id);

    List<EntradaBlogDTO> consultarBlogs();
}
