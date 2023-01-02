package com.example.frescos.service.db;

import com.example.frescos.entity.InboundOrder;
import com.example.frescos.service.InboundOrderService;

public interface InboundOrderDbService {
    InboundOrder save(InboundOrder inboundOrder);
    InboundOrder findByOrderNumber(Long orderNumber);
}
