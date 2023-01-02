package com.example.frescos.service;

import com.example.frescos.dtos.request.InboundOrderRequest;
import com.example.frescos.dtos.response.BatchStockResponseDTO;
import org.springframework.security.core.Authentication;

public interface InboundOrderService {
    BatchStockResponseDTO addInboundOrder(Authentication authentication, InboundOrderRequest inboundOrderRequest);
    BatchStockResponseDTO updateInboundOrder(Authentication authentication, InboundOrderRequest inboundOrderRequest);
}
