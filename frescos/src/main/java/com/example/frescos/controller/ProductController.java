package com.example.frescos.controller;

import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.service.ProductService;
import com.example.frescos.service.WarehouseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products")
public class ProductController {

    @Autowired
    ProductService productService;
    @Autowired
    WarehouseServiceImpl warehouseService;

    @GetMapping("/list")
    ResponseEntity<List<ProductDTO>> getAllByCategory(@RequestParam(required = false) String category) {
        return new ResponseEntity<>(productService.findByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/{idProduct}/batch/list")
    public ResponseEntity<?>findAllProductOrderBy(Authentication authentication, @PathVariable Long idProduct, @RequestParam(required=false) Character order){
        return new ResponseEntity(warehouseService.findByProduct(authentication, idProduct, order), HttpStatus.OK);
    }

}
