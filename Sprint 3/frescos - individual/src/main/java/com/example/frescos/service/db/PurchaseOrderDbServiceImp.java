package com.example.frescos.service.db;

import com.example.frescos.entity.PurchaseOrder;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.PurchaseOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public PurchaseOrder save(PurchaseOrder purchaseOrder) {
        return purchaseOrderRepository.saveAndFlush(purchaseOrder);
    }

    @Override
    public List<PurchaseOrder> findAllByBuyerId(Long buyerId) {
        List<PurchaseOrder> orders = purchaseOrderRepository.findAllByBuyerId(buyerId);
        if(orders.size()>0)
            return orders;
        else
            throw new EntityNotFoundException("El comprador " + buyerId + "no posee órdenes de compra.");
    }

    @Override
    public List<PurchaseOrder> findAllByBuyerUsername(String userName) {
        List<PurchaseOrder> orders = purchaseOrderRepository.findAllByBuyerUserName(userName);
        if(orders.size()>0)
            return orders;
        else
            throw new EntityNotFoundException("El comprador " + userName + "no posee órdenes de compra.");
    }
}
