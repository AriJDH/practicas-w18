package com.example.empresa_elasticsearch.repository;

import com.example.empresa_elasticsearch.domain.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {
}
