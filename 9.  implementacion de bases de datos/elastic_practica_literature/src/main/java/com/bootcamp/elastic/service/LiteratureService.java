package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.LiteratureDTORequest;
import com.bootcamp.elastic.dto.response.LiteratureDTOResponse;
import com.bootcamp.elastic.entity.Literature;
import com.bootcamp.elastic.repository.LiteratureRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class LiteratureService implements ILiteratureService{

    LiteratureRepository literatureRepository;
    ObjectMapper objectMapper;

    public LiteratureService(LiteratureRepository literatureRepository){
        this.literatureRepository = literatureRepository;
        this.objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES,false)
                                              .findAndRegisterModules();

    }

    public List<LiteratureDTOResponse> getAll(){
        return this.literatureRepository.findAll().stream().map(x->objectMapper.convertValue(x,LiteratureDTOResponse.class)).collect(Collectors.toList());
    }
    public List<LiteratureDTOResponse> getAllByAuthor(String author){
        return this.literatureRepository.findAllByAuthorIs(author).stream().map(x->objectMapper.convertValue(x,LiteratureDTOResponse.class)).collect(Collectors.toList());
    }

    public List<LiteratureDTOResponse> getAllByTitleKeyword(List<String> keywords){
        return this.literatureRepository.findAllByTitleIn(keywords).stream().map(x->objectMapper.convertValue(x,LiteratureDTOResponse.class)).collect(Collectors.toList());
    }
    public List<LiteratureDTOResponse> getAllByPagesGreater(int pages){
        return this.literatureRepository.findAllByCantPagesGreaterThan(pages).stream().map(x->objectMapper.convertValue(x,LiteratureDTOResponse.class)).collect(Collectors.toList());
    }
    public List<LiteratureDTOResponse> getAllByFirstPostBefore(LocalDate date){
        return this.literatureRepository.findAllByFirstPostBefore(date).stream().map(x->objectMapper.convertValue(x,LiteratureDTOResponse.class)).collect(Collectors.toList());

    }
    public List<LiteratureDTOResponse> getAllByFirstPostAfter(LocalDate date){
        return this.literatureRepository.findAllByFirstPostAfter(date).stream().map(x->objectMapper.convertValue(x,LiteratureDTOResponse.class)).collect(Collectors.toList());

    }
    public List<LiteratureDTOResponse> getAllByEditorial(String editorial){
        return this.literatureRepository.findAllByEditorialIs(editorial).stream().map(x->objectMapper.convertValue(x,LiteratureDTOResponse.class)).collect(Collectors.toList());

    }

    public List<LiteratureDTORequest> saveAll(List<LiteratureDTORequest> books){
        this.literatureRepository.saveAll(books.stream().map(x->objectMapper.convertValue(x,Literature.class)).collect(Collectors.toList()));
        return books;
    }

    public void deleteAll(){
        literatureRepository.deleteAll();
    }


}
