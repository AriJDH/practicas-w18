package com.bootcamp.elastic.service;

import com.bootcamp.elastic.dto.request.LiteratureDTORequest;
import com.bootcamp.elastic.dto.response.LiteratureDTOResponse;
import com.bootcamp.elastic.entity.Literature;

import java.time.LocalDate;
import java.util.List;

public interface ILiteratureService {

    List<LiteratureDTOResponse> getAll();
    List<LiteratureDTORequest> saveAll(List<LiteratureDTORequest> books);
    void deleteAll();

    List<LiteratureDTOResponse> getAllByAuthor(String author);
    List<LiteratureDTOResponse> getAllByTitleKeyword(List<String> keyword);
    List<LiteratureDTOResponse> getAllByPagesGreater(int pages);
    List<LiteratureDTOResponse> getAllByFirstPostBefore(LocalDate date);
    List<LiteratureDTOResponse> getAllByFirstPostAfter(LocalDate date);
    List<LiteratureDTOResponse> getAllByEditorial(String editorial);
}
