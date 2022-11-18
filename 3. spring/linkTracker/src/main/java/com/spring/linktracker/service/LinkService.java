package com.spring.linktracker.service;

import com.spring.linktracker.dto.LinkDtoReq;
import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;
import com.spring.linktracker.repository.ILinkRepository;
import com.spring.linktracker.repository.LinkRepository;
import com.spring.linktracker.utils.LinkMapper;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    ILinkRepository linkRepository;
    private static Long id = 0L;

    public LinkService(LinkRepository linkRepository){
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDtoRes createLink(LinkDtoReq link){
        return linkRepository.createLink(new Link(link.getUrl(), createId(), 0, true));
    }

    @Override
    public Integer getAnaliticsById(Long linkId) {
        return linkRepository.getAnaliticsById(linkId);
    }

    @Override
    public void invalidateLink(Long linkId) {

    }



    @Override
    public LinkDtoRes redirectLink(Long linkId) {
        addAnaliticsByID(linkId);
        return linkRepository.searchLinkById(linkId);
    }

    @Override
    public LinkDtoRes searchLink(Long linkId) {
        return linkRepository.searchLinkById(linkId);
    }

    public void addAnaliticsByID(Long linkId){
        linkRepository.addAnalitycsByID(linkId);
    }


    private Long createId(){
        id += 1;
        return id;
    }
}
