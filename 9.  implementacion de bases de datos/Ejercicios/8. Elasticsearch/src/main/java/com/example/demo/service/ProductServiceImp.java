package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.ProductDTO;
import com.example.demo.repository.IProductRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImp implements IProductService {
	
	// DEPENDENCIES --------------------------------------------- //
	
	final ObjectMapper mapper;
	final IProductRepository productRepository;
	
	public ProductServiceImp(ObjectMapper objectMapper,
	                         IProductRepository productRepository) {
		this.mapper = objectMapper;
		this.productRepository = productRepository;
	}
	
	// CRUD --------------------------------------------- //
	@Override
	public void save(ProductDTO productDTO) {
		Product product = mapper.convertValue(productDTO, Product.class);
		productRepository.save(product);
	}
	
	@Override
	public ProductDTO findById(String id) {
		Product productFound = productRepository.findById(id)
						.orElseThrow(() -> new NoSuchElementException("El id no fue encontrado"));
		return mapper.convertValue(productFound, ProductDTO.class);
	}
	
	@Override
	public List<ProductDTO> findAll() {
		Iterable<Product> productListFound = productRepository.findAll();
		List<ProductDTO> productDTOList = new ArrayList<>();
		for (Product product : productListFound) {
			productDTOList.add(mapper.convertValue(product, ProductDTO.class));
		}
		return productDTOList;
	}
	
	@Override
	public void delete(String id) {
		productRepository.deleteById(id);
	}
	
	@Override
	public void update(String id, ProductDTO productDTO) {
		Product productFound = productRepository.findById(id)
						.orElseThrow(() -> new NoSuchElementException("El id no fue encontrado"));
		Product newProduct = mapper.convertValue(productDTO, Product.class);
		newProduct.setId(id);
		productRepository.save(newProduct);
	}
}
