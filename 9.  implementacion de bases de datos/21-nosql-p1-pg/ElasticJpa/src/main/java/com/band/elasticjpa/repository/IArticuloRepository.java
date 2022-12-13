package com.band.elasticjpa.repository;

import com.band.elasticjpa.entity.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IArticuloRepository extends ElasticsearchRepository<Articulo, String> {
}
