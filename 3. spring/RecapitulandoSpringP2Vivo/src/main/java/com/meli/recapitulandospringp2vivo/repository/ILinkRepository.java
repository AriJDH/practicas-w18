package com.meli.recapitulandospringp2vivo.repository;

import com.meli.recapitulandospringp2vivo.entity.Link;

public interface ILinkRepository {
    Link save(Link link);
    Link findById(Integer id);
    void delete(Link link);
}
