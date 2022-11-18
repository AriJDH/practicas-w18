package com.example.spring.excepciones.tracker.service;

import com.example.spring.excepciones.tracker.dto.request.LinkDTOReq;
import com.example.spring.excepciones.tracker.dto.response.LinkDTORes;
import com.example.spring.excepciones.tracker.entity.Link;
import com.example.spring.excepciones.tracker.repository.LinkRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class LinkServiceImpl implements ILinkService{
    @Autowired
    LinkRepositoryImpl links;

    @Override
    public LinkDTORes createLink(LinkDTOReq linkRequest) {
        Integer id = links.createLink(new Link(linkRequest.getUrl()));
        return new LinkDTORes(id) ;
    }

    @Override
    public LinkDTORes getLink(LinkDTOReq linkRequest){

        return null;
    }
}
