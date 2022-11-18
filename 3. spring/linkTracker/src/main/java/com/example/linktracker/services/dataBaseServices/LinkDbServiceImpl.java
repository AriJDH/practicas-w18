package com.example.linktracker.services.dataBaseServices;

import com.example.linktracker.entities.Link;
import com.example.linktracker.exceptions.EntityNotFoundException;
import com.example.linktracker.repositories.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkDbServiceImpl implements LinkDbService{
    @Autowired
    private LinkRepository linkRepository;

    @Override
    public Link findById(long id) {
        return linkRepository.findById(id).orElseThrow(()->{throw new EntityNotFoundException("El link " + id + "no existe.");});
    }

    @Override
    public void add(Link link) {
        linkRepository.add(link);
    }
}
