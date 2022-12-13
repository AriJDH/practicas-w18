package com.example.demo.service;

import com.example.demo.model.dto.ProductDTO;

import java.util.List;

public interface IProductService {
	
	// CRUD --------------------------------------------- //
	void save(ProductDTO productDTO);
	ProductDTO findById(String id);
	List<ProductDTO> findAll();
	void delete(String id);
	void update(String id,ProductDTO productDTO);
}
