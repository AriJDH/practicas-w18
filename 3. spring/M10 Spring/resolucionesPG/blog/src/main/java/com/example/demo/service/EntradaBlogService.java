package com.example.demo.service;

import com.example.demo.dtos.EntradaBlogDTO;
import com.example.demo.exceptions.DuplicatedEntryBlogException;
import com.example.demo.exceptions.NotFoundEntradaBlogException;
import com.example.demo.mapper.EntradaMapper;
import com.example.demo.model.EntradaBlog;
import com.example.demo.repository.EntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class EntradaBlogService implements EntradaBlogServiceI {

    @Autowired
    private EntradaBlogRepository entradaBlogRepository;

    @Autowired
    private EntradaMapper entradaMapper;

    public EntradaBlogDTO crearNuevoBLog(EntradaBlogDTO entradaBlogDTO) {
        EntradaBlog entradaBlog1 = entradaBlogRepository.findById(entradaBlogDTO.getId());
        if (!Objects.isNull(entradaBlog1)) {
            throw new DuplicatedEntryBlogException();
        }
        EntradaBlog entradaBlog = entradaBlogRepository.nuevoBlog(entradaMapper.entradaBlogDTOToEntradaBlog(entradaBlogDTO));
        return entradaMapper.entradaBlogToEntradaBlogDTO(entradaBlog);

    }

    public EntradaBlogDTO getBlog(Long id) {
        EntradaBlog entradaBlog = entradaBlogRepository.findById(id);
        if (Objects.isNull(entradaBlog)) {
            throw new NotFoundEntradaBlogException();
        }
        return entradaMapper.entradaBlogToEntradaBlogDTO(entradaBlog);
    }

    public List<EntradaBlogDTO> getBlogs() {
        return entradaBlogRepository.getBlogs().stream().map(e -> entradaMapper.entradaBlogToEntradaBlogDTO(e)).collect(Collectors.toList());
    }


}

