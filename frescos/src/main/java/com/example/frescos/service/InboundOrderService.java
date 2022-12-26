package com.example.frescos.service;

import com.example.frescos.dtos.InboundOrderDTO;
import com.example.frescos.dtos.ResponseCreateDTO;
import com.example.frescos.entity.InboundOrder;

public interface InboundOrderService {
    InboundOrder addInboundOrder(InboundOrderDTO inboundOrderDTO);
}
