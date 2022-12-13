package com.example.demo.controller;

import com.example.demo.model.ProductDTO;
import com.example.demo.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	// DEPENDENCIES ------------------------------------- //
	final IProductService productService;
	
	public ProductController(IProductService productService) {
		
		this.productService = productService;
	}
	
	// CRUD --------------------------------------------- //
	@PostMapping
	public ResponseEntity<?> save(@RequestBody ProductDTO productDTO) {
		productService.save(productDTO);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> findById(@PathVariable String id) {
		ProductDTO productDTO = productService.findById(id);
		return ResponseEntity.ok().body(productDTO);
	}
	
	@GetMapping
	public ResponseEntity<?> findAll() {
		List<ProductDTO> productDTOList = productService.findAll();
		return ResponseEntity.ok().body(productDTOList);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable String id) {
		productService.delete(id);
		return ResponseEntity.ok().body("El elemento fue eliminado con éxito");
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable String id, @RequestBody ProductDTO productDTO) {
		productService.update(id, productDTO);
		return ResponseEntity.ok("El elemento fue modificado con éxito");
	}
	
}
