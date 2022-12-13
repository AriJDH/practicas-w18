package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {

    List<Literature> findAllByAuthor(String author);

    List<Literature> findAllByTitleIn(List<String> wordList);

    List<Literature> findAllByCantPagesGreaterThan(Integer cantPagesMin);

    List<Literature> findAllByFirstPostBefore(LocalDate date);

    List<Literature> findAllByFirstPostAfter(LocalDate date);

    List<Literature> findAllByEditorialMatchesRegex(String editorial);
}
