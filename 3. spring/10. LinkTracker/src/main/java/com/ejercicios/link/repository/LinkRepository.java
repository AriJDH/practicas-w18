package com.ejercicios.link.repository;

import com.ejercicios.link.domain.Link;

public interface LinkRepository {

    Link crear(Link link);

    Link findById(Long id);


}
