package com.myspace.blog.repository;

import com.myspace.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    List<EntradaBlog> getAll();
    Boolean addBlog(EntradaBlog entradaBlog);
    EntradaBlog getBlogById(int id);
}
