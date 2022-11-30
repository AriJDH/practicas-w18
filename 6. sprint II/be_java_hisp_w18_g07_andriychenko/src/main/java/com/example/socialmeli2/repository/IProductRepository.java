package com.example.socialmeli2.repository;

import com.example.socialmeli2.entity.ProductEntity;

import java.util.Map;

public interface IProductRepository {

    ProductEntity getEntityById(Integer productId);

    Map<Integer, ProductEntity> getAllEntity();

}
