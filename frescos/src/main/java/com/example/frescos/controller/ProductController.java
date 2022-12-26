package com.example.frescos.controller;

import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/list")
    ResponseEntity<List<ProductDTO>> getAllByCategory(@RequestParam(required = false) String category) {
        return new ResponseEntity<>(productService.findByCategory(category), HttpStatus.OK);
    }

}
