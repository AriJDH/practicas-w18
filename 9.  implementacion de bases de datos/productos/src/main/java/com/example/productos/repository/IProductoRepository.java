package com.example.productos.repository;

import com.example.productos.domain.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {
}
