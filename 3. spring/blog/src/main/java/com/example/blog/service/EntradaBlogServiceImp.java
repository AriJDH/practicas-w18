package com.example.blog.service;

import com.example.blog.dto.request.EntradaBlogDTORes;
import com.example.blog.dto.response.EntradaBlogDTOReq;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.IEntradaBlogRepository;
import com.example.blog.util.MapperConfigure;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EntradaBlogServiceImp implements IEntradaBlogService{
    private final IEntradaBlogRepository entradaBlogRepository;

    public EntradaBlogServiceImp(IEntradaBlogRepository entradaBlogRepository) {
        this.entradaBlogRepository = entradaBlogRepository;
    }

    @Override
    public void createBlog(EntradaBlogDTOReq entradaBlogDTOReq) {
        EntradaBlog entradaBlog = MapperConfigure.createObjectMapper().convertValue(entradaBlogDTOReq,EntradaBlog.class);
        entradaBlogRepository.createBlog(entradaBlog);
    }

    @Override
    public List<EntradaBlogDTORes> findAll() {
        return entradaBlogRepository.findAll().stream().map(p->MapperConfigure.createObjectMapper().convertValue(p,EntradaBlogDTORes.class)).collect(Collectors.toList());

    }

    @Override
    public EntradaBlogDTORes findyById(Integer id) {
        EntradaBlogDTORes entradaBlogDTORes = MapperConfigure.createObjectMapper().convertValue(entradaBlogRepository.findyById(id),EntradaBlogDTORes.class);
        return entradaBlogDTORes;
    }
}
