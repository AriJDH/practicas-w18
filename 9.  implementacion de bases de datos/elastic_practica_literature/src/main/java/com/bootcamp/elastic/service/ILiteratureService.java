package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;

import java.util.List;

public interface ILiteratureService {
    List<Literature> getAllByAuthor(String author);
    List<Literature> getAllByTitle(String title);
    List<Literature> getAllCantPagesGreaterThan(int cantPages);
    List<Literature> getAllFirstPostAfter(DateDTO dateDTO);
    List<Literature> getAllFirstPostBefore(DateDTO dateDTO);
}
