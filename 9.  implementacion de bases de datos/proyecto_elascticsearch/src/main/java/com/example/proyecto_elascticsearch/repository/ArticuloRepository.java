package com.example.proyecto_elascticsearch.repository;

import com.example.proyecto_elascticsearch.domain.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticuloRepository extends ElasticsearchRepository<Articulo, String> {
}
