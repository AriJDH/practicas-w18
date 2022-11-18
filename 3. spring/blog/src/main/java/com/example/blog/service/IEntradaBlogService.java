package com.example.blog.service;

import com.example.blog.dto.request.EntradaBlogDTORes;
import com.example.blog.dto.response.EntradaBlogDTOReq;

import java.util.List;

public interface IEntradaBlogService {
    void createBlog(EntradaBlogDTOReq entradaBlogDTOReq);

    List<EntradaBlogDTORes> findAll();

    EntradaBlogDTORes findyById(Integer id);

}
