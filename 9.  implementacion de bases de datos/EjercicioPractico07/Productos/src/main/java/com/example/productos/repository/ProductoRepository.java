package com.example.productos.repository;

import com.example.productos.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {

    @Override
    List<Producto> findAll();

}
