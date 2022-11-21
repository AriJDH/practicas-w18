package com.ejercicios.link.service;

import com.ejercicios.link.domain.Link;
import com.ejercicios.link.dto.LinkDto;
import com.ejercicios.link.dto.LinkIdDto;
import com.ejercicios.link.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService{

    private final LinkRepository repository;

    public LinkServiceImpl(LinkRepository repository) {
        this.repository = repository;
    }


    @Override
    public LinkIdDto crear(LinkDto link) {

        Link linkReal = new Link(link.getId(), link.getPath(), link.getPass(), false);

        repository.crear(linkReal);

        LinkIdDto linkIdDto = new LinkIdDto(link.getId());

        return linkIdDto;
    }

    @Override
    public String path(Long id) {

        Link link = repository.findById(id);

        if(link != null){

            return link.getPath();
        }

        return null;
    }
}
