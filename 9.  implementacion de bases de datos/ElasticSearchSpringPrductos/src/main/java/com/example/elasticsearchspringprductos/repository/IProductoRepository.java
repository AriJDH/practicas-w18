package com.example.elasticsearchspringprductos.repository;

import com.example.elasticsearchspringprductos.domain.Productos;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface IProductoRepository extends ElasticsearchRepository<Productos, String> {
}
