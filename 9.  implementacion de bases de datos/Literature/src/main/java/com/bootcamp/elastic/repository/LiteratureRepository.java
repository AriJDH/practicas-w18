package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
/*    @Override
    List<Literature> findAll();*/

    List<Literature> findLiteratureByAuthor(String author);

    List<Literature> findLiteratureByTitleIs(String words);

    List<Literature> findLiteratureByCantPagesGreaterThan(int page);

    List<Literature> findLiteratureByEditorialContaining(String editorial);

    List<Literature> findAllByFirstPostBefore(LocalDate date);

    List<Literature> findAllByFirstPostAfter(LocalDate date);
}
