package com.example.socialmeli.repository.interfaces;

import com.example.socialmeli.entity.ProductEntity;

import java.util.Map;

public interface IProductRepository {

    ProductEntity getEntityById(Integer productId);

    Map<Integer, ProductEntity> getAllEntity();

}
