package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.DateDTO;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LiteratureService implements ILiteratureService {
    @Autowired
    LiteratureRepository literatureRepository;

    @Override
    public List<Literature> getAllByAuthor(String author) {
        return literatureRepository.findAllByAuthorIs(author);
    }

    @Override
    public List<Literature> getAllByTitle(String title) {
        return literatureRepository.findAllByTitleIs(title);
    }

    @Override
    public List<Literature> getAllCantPagesGreaterThan(int cantPages) {
        return literatureRepository.findAllByCantPagesGreaterThan(cantPages);
    }

    @Override
    public List<Literature> getAllFirstPostAfter(DateDTO dateDTO) {
        return literatureRepository.findAllByFirstPostAfter(dateDTO.getDate());
    }

    @Override
    public List<Literature> getAllFirstPostBefore(DateDTO dateDTO) {
        return literatureRepository.findAllByFirstPostBefore(dateDTO.getDate());
    }
}
