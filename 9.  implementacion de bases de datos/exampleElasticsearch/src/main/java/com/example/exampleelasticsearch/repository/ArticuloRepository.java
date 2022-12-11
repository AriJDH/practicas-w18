package com.example.exampleelasticsearch.repository;

import com.example.exampleelasticsearch.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo,String> {
}
