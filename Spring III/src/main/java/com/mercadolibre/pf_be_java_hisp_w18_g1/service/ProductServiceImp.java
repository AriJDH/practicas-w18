package com.mercadolibre.pf_be_java_hisp_w18_g1.service;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ProductDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Product;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.EntityNotFoundException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImp implements ProductService{

    @Autowired
    ProductRepository productRespository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ProductDTO> findAllProducts() {
        List<Product> products = productRespository.findAll();
        if(products.isEmpty()) throw new EntityNotFoundException("Not Found");
        return products.stream()
                .map(element -> modelMapper.map(element, ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductDTO> findByCategory(String category) {
        List<Product> products;
        if (category != null) {
            products = productRespository.findByCategory(category);
        } else {
            products = productRespository.findAll();
        }
        if(products.isEmpty()) throw new EntityNotFoundException("Not Found");
        return products.stream()
                .map(element -> modelMapper.map(element, ProductDTO.class))
                .collect(Collectors.toList());
    }
}
