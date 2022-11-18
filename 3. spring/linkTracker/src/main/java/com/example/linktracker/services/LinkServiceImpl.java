package com.example.linktracker.services;

import com.example.linktracker.dtos.LinkDTO;
import com.example.linktracker.dtos.LinkMetricsDTO;
import com.example.linktracker.dtos.LinkReceptionDTO;
import com.example.linktracker.entities.Link;
import com.example.linktracker.services.dataBaseServices.LinkDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements LinkService{
    private int linkCounter = 0;
    @Autowired
    private LinkDbService linkDbService;

    @Override
    public LinkDTO createLink(LinkReceptionDTO linkReceptionDTO) {
        linkCounter++;
        linkDbService.add(new Link(linkCounter,linkReceptionDTO.getLink(), linkReceptionDTO.getPassword()));
        return new LinkDTO(linkCounter);
    }

    @Override
    public String getRedirectionLink(long id, String password) {
        Link link = linkDbService.findById(id);
        String redirectionLink =  link.getLink(password);
        link.addRedirection();
        return redirectionLink;
    }

    @Override
    public LinkMetricsDTO getMetrics(long id) {
        Link link =linkDbService.findById(id);
        return new LinkMetricsDTO(link.getId(), link.getRedirectionCount());
    }

    @Override
    public void invalidateLink(long id) {
        Link link =linkDbService.findById(id);
        link.setInvalidated(true);
    }
}
