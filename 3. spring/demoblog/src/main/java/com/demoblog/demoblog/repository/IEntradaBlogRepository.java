package com.demoblog.demoblog.repository;

import com.demoblog.demoblog.entity.EntradaBlog;

import java.util.Optional;


public interface IEntradaBlogRepository {
    EntradaBlog crearEntradaBlog(EntradaBlog entradaBlogDto);
    Optional<EntradaBlog> findById(Integer id);
}
