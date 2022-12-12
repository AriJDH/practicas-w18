package com.example.productos.repository;

import com.example.productos.domain.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {

    Producto save(Producto producto);

    List<Producto> findAll();

    void deleteById(String id);
}
