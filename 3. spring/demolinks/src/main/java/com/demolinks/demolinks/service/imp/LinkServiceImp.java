package com.demolinks.demolinks.service.imp;

import com.demolinks.demolinks.dto.request.LinkDtoReq;
import com.demolinks.demolinks.dto.response.LinkDtoRes;
import com.demolinks.demolinks.dto.response.LinkStatisticDtoRes;
import com.demolinks.demolinks.entity.Link;
import com.demolinks.demolinks.repository.ILinkRepository;
import com.demolinks.demolinks.service.ILinkService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class LinkServiceImp implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;


    ObjectMapper mapper = new ObjectMapper();

    @Override
    public LinkDtoRes createLink(LinkDtoReq linkDtoReq, String password) {
        Link link = new Link();
        link.setUrl(linkDtoReq.getUrl());
        link.setPassword(password);
        link.setContador(0);
        link.setLinkId(linkRepository.getLinkIdCounter());

        linkRepository.createLink(link);

        return null;

//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        mapper.createLink(linkDtoReq, Link.class);
//        return null;
    }

    @Override
    public LinkStatisticDtoRes getLinkStatistic(Integer linkId) {
        return null;
    }

    @Override
    public LinkDtoRes invalidateLink(LinkDtoReq linkDtoReq) {
        return null;
    }
}
