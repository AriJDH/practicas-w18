package com.mercadolibre.pf_be_java_hisp_w18_g1.controller;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.request.InboundOrderRequest;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.response.BatchStockResponseDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.InboundOrderService;
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
    public ResponseEntity<BatchStockResponseDTO> addInboundOrder(Authentication authentication,
                                                                 @RequestBody InboundOrderRequest inboundOrderRequest){
        return new ResponseEntity(inboundOrderService.addInboundOrder(authentication,
                inboundOrderRequest), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<BatchStockResponseDTO> updateInboundOrder(Authentication authentication,
                                                                    @RequestBody InboundOrderRequest inboundOrderRequest){
        return new ResponseEntity(inboundOrderService.updateInboundOrder(authentication,
                inboundOrderRequest), HttpStatus.CREATED);
    }
}
