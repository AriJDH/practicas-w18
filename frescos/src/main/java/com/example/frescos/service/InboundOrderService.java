package com.example.frescos.service;

import com.example.frescos.dtos.request.InboundOrderRequest;
import com.example.frescos.dtos.response.BatchStockResponse;
import com.example.frescos.dtos.InboundOrderDTO;
import org.springframework.security.core.Authentication;

public interface InboundOrderService {
    BatchStockResponse addInboundOrder(Authentication authentication, InboundOrderRequest inboundOrderRequest);
    BatchStockResponse updateInboundOrder(Authentication authentication, InboundOrderRequest inboundOrderRequest);
}
