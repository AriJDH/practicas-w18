package com.spring.blog.repository;

import com.spring.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogRepository {
    Integer addEntry(EntradaBlog entry);
    List<EntradaBlog> getAllEntries();
    EntradaBlog getEntryById(Integer id);
}
