package com.bootcamp.elastic.repository;

import com.bootcamp.elastic.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {
/*    @Override
    List<Literature> findAll();*/
    List<Literature> findAllByAuthorIs(String author);
    List<Literature> findAllByTitleIs(String title);
    List<Literature> findAllByCantPagesGreaterThan(int cantPages);
    List<Literature> findAllByFirstPostAfter(LocalDate localDate);
    List<Literature> findAllByFirstPostBefore(LocalDate localDate);
    // TODO:
    List<Literature> findAllByEditorial();
}
