package com.example.linktracker.service;

import com.example.linktracker.entity.Link;
import com.example.linktracker.repository.ILinkRepository;
import com.example.linktracker.repository.LinkRepositoryImp;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

@Service
public class LinkServiceImp implements ILinkService{

    private ILinkRepository linkRepository;

    public LinkServiceImp(LinkRepositoryImp linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public Long createLink(String url) {
        Long link = linkRepository.createLink(url);
        return link;
    }

    @Override
    public Link findById(Long linkId){
        Link link = linkRepository.findById(linkId);
        return link;
    }

    @Override
    public RedirectView redirect(Long linkId) {
        Link link = linkRepository.findById(linkId);
        return new RedirectView(link.getUrl());
    }


    @Override
    public void deleteLink(Long linkId) {
        linkRepository.deleteLink(linkId);
    }

    @Override
    public Integer getMetrics(Long linkId){
        return linkRepository.getMetrics(linkId);
    }

}
