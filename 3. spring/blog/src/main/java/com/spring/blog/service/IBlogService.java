package com.spring.blog.service;

import com.spring.blog.dto.EntradaBlogDtoReq;
import com.spring.blog.dto.EntradaBlogDtoRes;
import com.spring.blog.dto.IdDto;
import com.spring.blog.entity.EntradaBlog;

import java.util.List;

public interface IBlogService {
    IdDto addEntry(EntradaBlogDtoReq entry);
    List<EntradaBlogDtoRes> getAllEntries();
    EntradaBlogDtoRes getEntryById(Integer id);
}
