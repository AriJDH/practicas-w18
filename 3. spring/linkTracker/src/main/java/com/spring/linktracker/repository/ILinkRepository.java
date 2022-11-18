package com.spring.linktracker.repository;

import com.spring.linktracker.entity.Link;
import org.springframework.http.ResponseEntity;

public interface ILinkRepository {
    Link createLink(Link link);
    int getAnaliticsById(Long linkId);
    void invalidateLink(Long linkId);

}
