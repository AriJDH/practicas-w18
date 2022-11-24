package com.jcundere.ejerciciopractico08.service;

import com.jcundere.ejerciciopractico08.dto.request.EntradaBlogRequest;
import com.jcundere.ejerciciopractico08.dto.response.EntradaBlogResponse;

import java.util.List;

public interface IEntradaBlogService {

    EntradaBlogResponse createEntity(EntradaBlogRequest request);

    EntradaBlogResponse getEntityById(Integer id);

    List<EntradaBlogResponse> getAllEntity();

}
