package com.example.socialmeli.repository;

import com.example.socialmeli.entity.ProductEntity;

import java.util.Map;

public interface IProductRepository {

    ProductEntity getEntityById(Integer id);

    Map<Integer, ProductEntity> getAllEntity();

}
