package com.mercadolibre.pf_be_java_hisp_w18_g1.service;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.request.InboundOrderRequest;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.response.BatchStockResponseDTO;
import org.springframework.security.core.Authentication;

public interface InboundOrderService {
    BatchStockResponseDTO addInboundOrder(Authentication authentication, InboundOrderRequest inboundOrderRequest);
    BatchStockResponseDTO updateInboundOrder(Authentication authentication, InboundOrderRequest inboundOrderRequest);
}
