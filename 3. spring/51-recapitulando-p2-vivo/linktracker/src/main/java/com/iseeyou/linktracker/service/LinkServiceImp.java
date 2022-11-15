package com.iseeyou.linktracker.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.iseeyou.linktracker.dto.request.LinkDTOReq;
import com.iseeyou.linktracker.dto.response.LinkDTORes;
import com.iseeyou.linktracker.dto.response.LinkStatisticDTORes;
import com.iseeyou.linktracker.entity.Link;
import com.iseeyou.linktracker.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LinkServiceImp implements ILinkService {

    @Autowired
    private ILinkRepository linkRepository;
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public LinkDTORes createLink(LinkDTOReq linkDTOReq, String password) {
        Link link = new Link(linkRepository.getLinkIdCounter(),
                linkDTOReq.getUrl(), 0, password);

        linkRepository.createLink(link);
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper.convertValue(link, LinkDTORes.class);
    }

    @Override
    public LinkStatisticDTORes getLinkStatistic(Integer linkId) {
        return null;
    }

    @Override
    public void invalidateLink(LinkDTOReq linkDTOReq) {

    }
}
