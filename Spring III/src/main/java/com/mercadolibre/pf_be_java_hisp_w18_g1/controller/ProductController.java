package com.mercadolibre.pf_be_java_hisp_w18_g1.controller;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ProductDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.ProductService;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.WarehouseServiceImpl;
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
    ResponseEntity<List<ProductDTO>> getAllByCategory(Authentication authentication,
                                                      @RequestParam(required = false) String category) {
        return new ResponseEntity<>(productService.findByCategory(category), HttpStatus.OK);
    }

    @GetMapping("/{idProduct}/warehouse/list")
    public ResponseEntity<?>getAllProduct(Authentication authentication,
                                          @PathVariable Long idProduct){
        return new ResponseEntity(warehouseService.findByProduct(authentication, idProduct), HttpStatus.OK);
    }

    @GetMapping("/{idProduct}/batch/list")
    public ResponseEntity<?>getAllProductOrderBy(Authentication authentication,
                                                 @PathVariable Long idProduct,
                                                 @RequestParam(required=false) Character order){
        return new ResponseEntity(warehouseService.findByProductForSection(authentication, idProduct, order), HttpStatus.OK);
    }

    @GetMapping("/minimumStock/list")
    public ResponseEntity<?>getAllProductWithLessStock(Authentication authentication,
                                                       @RequestParam Long id_warehouse,
                                                       @RequestParam Integer minimum_stock){
        return new ResponseEntity(warehouseService.findAllProductForSectionInWarehouse(authentication, id_warehouse, minimum_stock), HttpStatus.OK);
    }
}
