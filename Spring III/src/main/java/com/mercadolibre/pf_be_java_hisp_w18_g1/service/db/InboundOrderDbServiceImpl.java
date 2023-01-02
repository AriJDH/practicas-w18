package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.InboundOrder;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.EntityNotFoundException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.InboundOrderRepository;
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
