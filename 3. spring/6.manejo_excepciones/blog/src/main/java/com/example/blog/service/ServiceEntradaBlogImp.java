package com.example.blog.service;

import com.example.blog.dto.request.EntradaBlogRequestDTO;
import com.example.blog.dto.response.EntradaBlogResponseDTO;
import com.example.blog.dto.response.EntradaBlogResponseIdDTO;
import com.example.blog.entity.EntradaBlog;
import com.example.blog.exception.ConflictResourceException;
import com.example.blog.exception.NotFoundException;
import com.example.blog.repository.IRepositoryEntradaBlog;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceEntradaBlogImp implements IServiceEntradaBlog{

    private IRepositoryEntradaBlog database;
    private ObjectMapper op = new ObjectMapper();

    public ServiceEntradaBlogImp(IRepositoryEntradaBlog database) {
        this.database = database;
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public EntradaBlogResponseIdDTO add(EntradaBlogRequestDTO entrada) {
        EntradaBlog entradaBlog = database.findById(entrada.getId());
        if(entradaBlog != null){
            throw new ConflictResourceException("Ya existe una entrada en el blog con id " + entrada.getId());
        }
        database.add(op.convertValue(entrada, EntradaBlog.class));
        return new EntradaBlogResponseIdDTO(entrada.getId());
    }

    @Override
    public List<EntradaBlogResponseDTO> listAll() {
        return database.listAll().stream().map(x->op.convertValue(x, EntradaBlogResponseDTO.class)).collect(Collectors.toList());
    }

    @Override
    public EntradaBlogResponseDTO findById(Long id) {
        EntradaBlog entradaBlog = database.findById(id);
        if(entradaBlog == null){
            throw new NotFoundException("No existe la entrada del blog con id " + id);
        }
        return op.convertValue(entradaBlog, EntradaBlogResponseDTO.class);
    }
}
