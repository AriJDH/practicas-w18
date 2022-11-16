package com.example.linktracker.repository;

import com.link.entity.Link;

public interface ILinkRepository {

    Link crearLink(Link link);

    Integer obtenerEstadisticaLink(Long id);

    void invalidarLink(Long id);

    Link redireccionarLink(Long id, String password);

    Link findById(Long id);
}
