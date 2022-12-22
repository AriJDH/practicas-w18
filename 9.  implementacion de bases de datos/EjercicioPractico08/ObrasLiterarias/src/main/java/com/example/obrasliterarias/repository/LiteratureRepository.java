package com.example.obrasliterarias.repository;

import com.example.obrasliterarias.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {

    @Override
    List<Literature> findAll();

    List<Literature> getLiteratureByAuthor(String author);

    List<Literature> getLiteratureByTitleContainsIgnoreCase(String title);

    List<Literature> getLiteratureByCantPagesIsGreaterThan(Integer cantPages);

    List<Literature> getLiteratureByFirstPostAfter(LocalDate date);

    List<Literature> getLiteratureByFirstPostBefore(LocalDate date);

    List<Literature> getLiteratureByEditorialIs(String editorial);

}
