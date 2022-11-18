package com.spring.linktracker.service;

import com.spring.linktracker.dto.LinkDtoReq;
import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;

public interface ILinkService {
    LinkDtoRes createLink(LinkDtoReq link);
    int getAnaliticsById(Long linkId);
    void invalidateLink(Long linkId);
}
