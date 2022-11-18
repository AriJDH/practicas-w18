package com.mercadolibre.linktracker.repository;

import com.mercadolibre.linktracker.entity.Link;

import java.util.List;

public interface ILinkRepository {
    List<Link> getAll();
    Link findById(Long linkid);
    Integer getMetrics(Long linkid);
    void invalidate(Long linkid);
    Link create(Link link);

}
