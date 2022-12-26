package com.example.frescos.service;

import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.entity.Product;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.ProductRepository;
import org.mockito.internal.matchers.Null;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
