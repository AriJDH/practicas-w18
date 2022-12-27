package com.example.frescos.service.db;

import com.example.frescos.entity.PurchaseOrder;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseOrderDbServiceImp implements PurchaseOrderDbService{

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Override
    public PurchaseOrder findByOrderNumber(Long order) {
        return purchaseOrderRepository.findByOrderNumber(order)
                .orElseThrow(()->{throw new EntityNotFoundException("purchaseOrder " + order + "no existe.");});
    }

    @Override
    public void delete(PurchaseOrder purchaseOrder) {
        purchaseOrderRepository.delete(purchaseOrder);
    }
}
