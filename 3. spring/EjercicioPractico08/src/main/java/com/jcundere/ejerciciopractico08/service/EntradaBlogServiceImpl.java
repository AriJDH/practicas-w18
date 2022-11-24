package com.jcundere.ejerciciopractico08.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcundere.ejerciciopractico08.dto.request.EntradaBlogRequest;
import com.jcundere.ejerciciopractico08.dto.response.EntradaBlogResponse;
import com.jcundere.ejerciciopractico08.entity.EntradaBlog;
import com.jcundere.ejerciciopractico08.exception.NotFoundException;
import com.jcundere.ejerciciopractico08.repository.IEntradaBlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EntradaBlogServiceImpl implements IEntradaBlogService {

    private final IEntradaBlogRepository entradaBlogRepository;


    @Override
    public EntradaBlogResponse createEntity(EntradaBlogRequest request) {

        ObjectMapper op = new ObjectMapper();
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        entradaBlogRepository.createEntity(op.convertValue(request, EntradaBlog.class));

        return op.convertValue(request, EntradaBlogResponse.class);
    }

    @Override
    public EntradaBlogResponse getEntityById(Integer id) {

        ObjectMapper op = new ObjectMapper();
        EntradaBlogResponse response = op.convertValue(entradaBlogRepository.getEntityById(id), EntradaBlogResponse.class);

        if (response == null){
            throw new NotFoundException("ID: " + id + " de Entrada de Blog Inexistente !");
        }

        return response;
    }

    @Override
    public List<EntradaBlogResponse> getAllEntity() {

        entradaBlogRepository.getAllEntity().forEach(System.out::println);
        ObjectMapper op = new ObjectMapper();
        return entradaBlogRepository.getAllEntity()
                .stream()
                .map(entradaBlog -> op.convertValue(entradaBlog, EntradaBlogResponse.class))
                .collect(Collectors.toList());

    }

}
