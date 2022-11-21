package com.ejercicios.link.repository;

import com.ejercicios.link.domain.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkRepositoryImpl implements LinkRepository{

    Map<Long, Link> links = new HashMap<>();

    @Override
    public Link crear(Link link) {

        return links.put(link.getId(),link);

    }

    @Override
    public Link findById(Long id) {

        return links.get(id);
    }
}
