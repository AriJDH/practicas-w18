package com.bootcamp.be_java_hisp_w18_g06.controller;

import com.bootcamp.be_java_hisp_w18_g06.dto.request.PostDTO;
import com.bootcamp.be_java_hisp_w18_g06.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	// Inyección de dependencias por constructor
	private final IProductService productService;
	
	public ProductController(IProductService productService) {
		this.productService = productService;
	}
	
	// US006
	@GetMapping("/followed/{userId}/list")
	public ResponseEntity<List<PostDTO>> findAllByUser(@PathVariable int userId,
	                                                   @RequestParam(required = false) String order) {
		return ResponseEntity
						.ok(productService
										    .findAllPostsByUser(userId, order));
	}
	
	@PostMapping("/post")
	public ResponseEntity<?> save(@Valid @RequestBody PostDTO postDTO) {
		productService.save(postDTO);
		return ResponseEntity.ok("OK");
	}
}
