package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Product;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.EntityNotFoundException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.ProductRepository;
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
