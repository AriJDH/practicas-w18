package com.spring.linktracker.repository;

import com.spring.linktracker.dto.LinkDtoRes;
import com.spring.linktracker.entity.Link;
import org.springframework.http.ResponseEntity;

public interface ILinkRepository {
    LinkDtoRes createLink(Link link);
    Integer getAnaliticsById(Long linkId);
    void invalidateLink(Long linkId);
    void addAnalitycsByID(Long LinkId);
    public LinkDtoRes searchLinkById(Long linkId);
    public LinkDtoRes searchLink(Long linkId);
    public Link searchLinkForAnalitics(Long linkId);
}
