package com.example.frescos.service.db;

import com.example.frescos.entity.InboundOrder;
import com.example.frescos.exception.EntityNotFoundException;
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

    @Override
    public InboundOrder findByOrderNumber(Long orderNumber) {
        return inboundOrderRepository.findByOrderNumber(orderNumber)
                .orElseThrow(()->{throw new EntityNotFoundException("La orden " + orderNumber + " no existe en la base de datos.");});
    }
}
