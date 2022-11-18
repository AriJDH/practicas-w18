package com.spring.linktracker.service;

import com.spring.linktracker.dto.LinkDtoReq;
import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;

public interface ILinkService {
    public LinkDtoRes createLink(LinkDtoReq link);
    Integer getAnaliticsById(Long linkId);
    void invalidateLink(Long linkId);
    public LinkDtoRes redirectLink(Long linkId);
    public LinkDtoRes searchLink(Long linkId);

}
