package com.example.frescos.controller;

import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.dtos.request.PurchaseOrderRequest;
import com.example.frescos.dtos.response.PurchaseOrderCreationResponseDTO;
import com.example.frescos.service.PurchaseOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fresh-products/orders")
public class PurchaseOrderController {

    @Autowired
    PurchaseOrderService purchaseOrderService;

    @GetMapping("/{order}")
    ResponseEntity<List<ProductDTO>> getProductsByPurchaseOrder(Authentication authentication, @PathVariable Long order) {
        return new ResponseEntity<>(purchaseOrderService.findProductsByOrder(order), HttpStatus.OK);
    }

    @PostMapping
    ResponseEntity<PurchaseOrderCreationResponseDTO> addPurchaseOrder(Authentication authentication, @RequestBody PurchaseOrderRequest purchaseOrderRequest){
        return new ResponseEntity<>(purchaseOrderService.addPurchaseOrder(purchaseOrderRequest), HttpStatus.CREATED);
    }
    @PutMapping("/{orderId}")
    ResponseEntity<PurchaseOrderCreationResponseDTO> updatePurchaseOrder(Authentication authentication, @RequestBody PurchaseOrderRequest purchaseOrderRequest, @PathVariable Long orderId){
        return new ResponseEntity<>(purchaseOrderService.updatePurchaseOrder(orderId, purchaseOrderRequest), HttpStatus.CREATED);
    }
}
