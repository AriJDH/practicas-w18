package com.bootcamp.be_java_hisp_w18_g06.controller;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private IProductService productService;
	
	// US006
	@GetMapping("/followed/{userId}/list")
	public ResponseEntity<List<PostDTO>> findAllByUser(@PathVariable int userId) {
		return ResponseEntity.ok(productService.findAllPostsByUser(userId));
	}
	
	
}
