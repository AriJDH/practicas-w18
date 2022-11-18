package com.spring.linktracker.service;

import com.spring.linktracker.dto.LinkDtoReq;
import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;
import com.spring.linktracker.repository.ILinkRepository;
import com.spring.linktracker.repository.LinkRepository;
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
        linkRepository.createLink(new Link(link.getUrl(), createId(), 0, true));
        return null;
    }

    @Override
    public int getAnaliticsById(Long linkId) {
        return 0;
    }

    @Override
    public void invalidateLink(Long linkId) {

    }

    private Long createId(){
        id += 1;
        return id;
    }
}
