package com.example.frescos.service;

import com.example.frescos.dtos.InboundOrderDTO;
import com.example.frescos.dtos.ResponseCreateDTO;

public interface IInboundOrderService {
    ResponseCreateDTO addInboundOrder(InboundOrderDTO inboundOrderDTO);
}
