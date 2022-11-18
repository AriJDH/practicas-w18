package com.example.socialmeli.repository;

import com.example.socialmeli.entity.ProductEntity;
import com.example.socialmeli.entity.UserEntity;
import com.example.socialmeli.exception.NotFoundException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    Map<Integer, ProductEntity> products = new HashMap<>();
    public ProductRepositoryImpl() {
        products.put(1, new ProductEntity(1, "Silla Gamer", "Gamer", "Racer", "Red & Black","Special Edition"));
        products.put(1, new ProductEntity(62, "Headset RGB Inalámbrico", "Gamer", "Racer", "Green with RGB","Sin Batería"));
        products.put(1, new ProductEntity(869, "Teclado", "Gamer", "Racer", "Yelow & White","Special Edition"));
        products.put(1, new ProductEntity(2, "Audifonos gamer", "Gamer", "Redragon Ares", "Red & Black","Special Edition"));
        products.put(1, new ProductEntity(2, "Monitor", "Gamer", "Samsung F22T35 led 22", "dark blue gray 100V/240V","Una experiencia visual de calidad"));
    }

    @Override
    public ProductEntity getEntityById(Integer id) {
        if(this.products.get(id) == null){
            throw new NotFoundException("No existe producto con ID: " + id);
        }
        return products.get(id);
    }

    @Override
    public Map<Integer, ProductEntity> getAllEntity() {
        return products;
    }
}
