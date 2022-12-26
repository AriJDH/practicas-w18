package com.example.frescos.controller;

import com.example.frescos.dtos.request.InboundOrderRequest;
import com.example.frescos.dtos.response.BatchStockResponse;
import com.example.frescos.dtos.InboundOrderDTO;
import com.example.frescos.service.InboundOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fresh-products/inboundorder")
public class InboundOrderController {
    @Autowired
    private InboundOrderService inboundOrderService;
    @PostMapping
    public ResponseEntity<BatchStockResponse> addInboundOrder(Authentication authentication,@RequestBody InboundOrderRequest inboundOrderRequest){
        return new ResponseEntity(inboundOrderService.addInboundOrder(authentication, inboundOrderRequest), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<BatchStockResponse> updateInboundOrder(Authentication authentication, @RequestBody InboundOrderRequest inboundOrderRequest){
        return new ResponseEntity(inboundOrderService.updateInboundOrder(authentication, inboundOrderRequest), HttpStatus.CREATED);
    }
}
