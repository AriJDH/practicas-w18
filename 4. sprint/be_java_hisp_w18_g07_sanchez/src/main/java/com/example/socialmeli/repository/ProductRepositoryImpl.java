package com.example.socialmeli.repository;

import com.example.socialmeli.entity.ProductEntity;
import com.example.socialmeli.exception.NotFoundException;
import com.example.socialmeli.repository.interfaces.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class ProductRepositoryImpl implements IProductRepository {

    private Map<Integer, ProductEntity> products = new HashMap<>();

    public ProductRepositoryImpl() {

        products.put(1, new ProductEntity(1, "Silla Gamer", "Gamer", "Racer", "Red & Black", "Special Edition"));
        products.put(2, new ProductEntity(2, "Headset RGB Inalámbrico", "Gamer", "Racer", "Green with RGB", "Sin Batería"));
        products.put(3, new ProductEntity(3, "Teclado", "Gamer", "Racer", "Yelow & White", "Special Edition"));
        products.put(4, new ProductEntity(4, "Audifonos gamer", "Gamer", "Redragon Ares", "Red & Black", "Special Edition"));
        products.put(5, new ProductEntity(5, "Monitor", "Gamer", "Samsung F22T35 led 22", "dark blue gray 100V/240V", "Una experiencia visual de calidad"));

    }

    @Override
    public ProductEntity getEntityById(Integer productId) {
        if (this.products.get(productId) == null) {
            throw new NotFoundException("No existe producto con ID: " + productId);
        }

        return products.get(productId);
    }

    @Override
    public Map<Integer, ProductEntity> getAllEntity() {
        return products;
    }

}
