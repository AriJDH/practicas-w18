package com.example.frescos.service;

import com.example.frescos.dtos.ItemDTO;
import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.dtos.PurchaseOrderDTO;
import com.example.frescos.dtos.request.PurchaseOrderRequest;
import com.example.frescos.dtos.response.NotStockDTO;
import com.example.frescos.entity.Batch;
import com.example.frescos.entity.Item;
import com.example.frescos.entity.Product;
import com.example.frescos.entity.PurchaseOrder;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.exception.InsuficientStockException;
import com.example.frescos.repository.BatchRepository;
import com.example.frescos.repository.PurchaseOrderRepository;
import com.example.frescos.service.db.PurchaseOrderDbService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImp implements PurchaseOrderService{

    @Autowired
    PurchaseOrderDbService purchaseOrderDbService;

    @Autowired
    PurchaseOrderRepository purchaseOrderRepository;

    @Autowired
    BatchRepository batchRepository;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ProductDTO> findProductsByOrder(Long order) {
        PurchaseOrder purchaseOrder = purchaseOrderDbService.findByOrderNumber(order);
        return purchaseOrder.getItems().stream()
                .map(element -> modelMapper.map(element.getProduct(), ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public void addPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest) {
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderRequest.getPurchaseOrderDTO();
        List<ItemDTO> itemsDTO = purchaseOrderDTO.getItems();
        String productsIdNotStock = "";
        List<Long> products = itemsDTO.stream()
                .map(element -> {
                    return element.getProductId();
                }).collect(Collectors.toList());
        for(int i = 0; i < products.size(); i++) {
            if(products.get(i) < batchRepository.findQuantityByProductId(products.get(i))) {
                productsIdNotStock += products.get(i);
            }
        }
        if (productsIdNotStock.length() > 0) {
            throw new InsuficientStockException("Stock insuficciende de los productos" + productsIdNotStock);
        } else {
            itemsDTO.stream()
                    .forEach(element -> {
                        Integer quantity = element.getQuantity();
                        List<Batch> batches = batchRepository.findBatchByProductId(element.getProductId());
                        for (int i = 0; i < batches.size(); i ++) {
                            if (quantity > batches.get(i).getCurrentQuantity()) {
                                quantity -= batches.get(i).getCurrentQuantity();
                                batches.get(i).setCurrentQuantity(0);
                                batchRepository.saveAndFlush(batches.get(i));
                            } else {
                                batches.get(i).setCurrentQuantity(batches.get(i).getCurrentQuantity() - quantity);
                                quantity = 0;
                                batchRepository.saveAndFlush(batches.get(i));
                            }
                        }
                    });
            PurchaseOrder purchaseOrder = modelMapper.map(purchaseOrderDTO, PurchaseOrder.class);
            purchaseOrderRepository.saveAndFlush(purchaseOrder);
        }
    }
}
