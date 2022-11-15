package com.blog.blog_youtube.repository;

import com.blog.blog_youtube.dto.EntradaBlogDTO;
import com.blog.blog_youtube.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {

    Long crearBlog(EntradaBlog entradaBlog);

    EntradaBlog consultarBlogPorId(Long id);

    List<EntradaBlog> consultarBlogs();

}
