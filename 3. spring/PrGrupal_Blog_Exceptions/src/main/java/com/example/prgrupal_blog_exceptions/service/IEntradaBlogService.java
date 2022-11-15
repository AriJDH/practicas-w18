package com.example.prgrupal_blog_exceptions.service;

import com.example.prgrupal_blog_exceptions.dto.request.EntradaBlogDtoReq;
import com.example.prgrupal_blog_exceptions.dto.response.EntradaBlogDtoRes;

import java.util.List;

public interface IEntradaBlogService {
    String crearEntradaBlog(EntradaBlogDtoReq e);
    EntradaBlogDtoRes obtenerEntradaBlog(String id);
    List<EntradaBlogDtoRes> obtenerTodasLasEntradas();
}
