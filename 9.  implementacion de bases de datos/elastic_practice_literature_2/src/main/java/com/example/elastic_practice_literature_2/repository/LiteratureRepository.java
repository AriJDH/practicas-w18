package com.example.elastic_practice_literature_2.repository;

import com.example.elastic_practice_literature_2.entity.Literature;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.time.LocalDate;
import java.util.List;

public interface LiteratureRepository extends ElasticsearchRepository<Literature, String> {

    List<Literature> findAll();

    List<Literature> findByAutor(String autor);

    List<Literature> findByNombreObraIn(List<String> words);

    List<Literature> findByCantidadPaginasGreaterThan(Integer cantidadPaginas);

    List<Literature> findByFirstPostBefore(LocalDate fecha);

    List<Literature> findByFirstPostAfter(LocalDate fecha);

    List<Literature> findByEditorial(String editorial);
}
