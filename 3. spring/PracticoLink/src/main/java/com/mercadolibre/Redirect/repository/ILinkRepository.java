package com.mercadolibre.Redirect.repository;

import com.mercadolibre.Redirect.entity.Link;

public interface ILinkRepository {
    Link createLink(Link link);
    Integer getLinkCounter(int id);
    void invalidateLink(int id);
    Link redirectLink(int id, String password);
    Link findById(int id);
}
