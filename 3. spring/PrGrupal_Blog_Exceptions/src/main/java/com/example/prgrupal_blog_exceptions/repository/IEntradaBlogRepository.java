package com.example.prgrupal_blog_exceptions.repository;

import com.example.prgrupal_blog_exceptions.entity.EntradaBlog;

import java.util.List;

public interface IEntradaBlogRepository {
    EntradaBlog crearEntradaBlog(EntradaBlog e);
    EntradaBlog obtenerEntradaBlog(String id);
    List<EntradaBlog> obtenerTodasLasEntradas();
}
