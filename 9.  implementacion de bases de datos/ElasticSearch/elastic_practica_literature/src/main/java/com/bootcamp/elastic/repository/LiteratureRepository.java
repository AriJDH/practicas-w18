package com.bootcamp.elastic.repository;

import java.time.LocalDate;
import java.util.List;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface LiteratureRepository extends ElasticsearchRepository<Literature, String>{
    void deleteAll();
    List<Literature> findAll();
    Literature save(Literature literature);

    List<Literature> findAllByAuthor(String author);

    List<Literature> findAllByTitleIn(List<String> wordList);

    List<Literature> findAllByCantPagesGreaterThan(Integer cantPagesMin);

    List<Literature> findAllByFirstPostBefore(LocalDate date);

    List<Literature> findAllByFirstPostAfter(LocalDate date);

    List<Literature> findAllByEditorial(String editorial);
}
