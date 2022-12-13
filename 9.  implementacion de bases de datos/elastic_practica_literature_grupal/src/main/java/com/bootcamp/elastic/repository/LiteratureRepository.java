package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
    @Override
    List<Literature> findAll();

    List<Literature> findByAuthor(String author);
    List<Literature> findByEditorial(String editorial);


    List<Literature> findByTitle(String strsToMatch);

    List<Literature> findByPagesIsGreaterThan(int cant);
    List<Literature> findByFirstPostBefore(LocalDate date);
    List<Literature> findByFirstPostIsAfter(LocalDate date);
}