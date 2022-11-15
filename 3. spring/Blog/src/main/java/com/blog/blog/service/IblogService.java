package com.blog.blog.service;

import com.blog.blog.dto.request.EntradaBlogDTOreq;
import com.blog.blog.dto.response.CreacionDTOres;
import com.blog.blog.dto.response.EntradaBlogDTOres;
import com.blog.blog.entity.EntradaBlog;

import java.util.List;

public interface IblogService {
    List<EntradaBlogDTOres> findAll();
    EntradaBlogDTOres findById(Long id);
    CreacionDTOres addEntradaBlog(EntradaBlogDTOreq entrada);
}
