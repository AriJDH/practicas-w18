package com.example.frescos.service.db;

import com.example.frescos.entity.Product;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDbServiceImpl implements ProductDbService{
    @Autowired
    private ProductRepository productRepository;
    @Override
    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->{throw new EntityNotFoundException("El producto " + id + " no existe.");
        });
    }
}
