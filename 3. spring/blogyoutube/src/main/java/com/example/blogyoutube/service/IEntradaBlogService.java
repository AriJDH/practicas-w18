package com.example.blogyoutube.service;


import com.example.blogyoutube.dto.request.EntradaBlogDtoReq;
import com.example.blogyoutube.dto.response.EntradaBlogMessage;
import com.example.blogyoutube.dto.response.EntradaBlogRes;

import java.util.Map;


public interface IEntradaBlogService {

    public EntradaBlogMessage save(EntradaBlogDtoReq blogDto);

    public EntradaBlogRes findById(Integer id);

    public Map<Integer, EntradaBlogRes> findAll();
}
