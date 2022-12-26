package com.example.frescos.service.db;

import com.example.frescos.entity.InboundOrder;
import com.example.frescos.repository.InboundOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InboundOrderDbServiceImpl implements InboundOrderDbService{
    @Autowired
    private InboundOrderRepository inboundOrderRepository;
    @Override
    public InboundOrder save(InboundOrder inboundOrder) {
        return inboundOrderRepository.save(inboundOrder);
    }
}
