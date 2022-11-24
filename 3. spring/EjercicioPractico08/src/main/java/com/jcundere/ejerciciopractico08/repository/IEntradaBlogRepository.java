package com.jcundere.ejerciciopractico08.repository;

import com.jcundere.ejerciciopractico08.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {

    EntradaBlog createEntity(EntradaBlog entradaBlog);

    EntradaBlog getEntityById(Integer id);

    List<EntradaBlog> getAllEntity();

}
