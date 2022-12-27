package com.example.frescos.service;

import com.example.frescos.dtos.ItemDTO;
import com.example.frescos.dtos.ProductDTO;
import com.example.frescos.dtos.PurchaseOrderDTO;
import com.example.frescos.dtos.request.PurchaseOrderRequest;
import com.example.frescos.dtos.response.PurchaseOrderCreationResponseDTO;
import com.example.frescos.entity.Batch;
import com.example.frescos.entity.PurchaseOrder;
import com.example.frescos.exception.InsuficientStockException;
import com.example.frescos.repository.BatchRepository;
import com.example.frescos.repository.PurchaseOrderRepository;
import com.example.frescos.service.db.PurchaseOrderDbService;
import com.example.frescos.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PurchaseOrderServiceImp implements PurchaseOrderService{

    @Autowired
    private PurchaseOrderDbService purchaseOrderDbService;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private BatchRepository batchRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public List<ProductDTO> findProductsByOrder(Long order) {
        PurchaseOrder purchaseOrder = purchaseOrderDbService.findByOrderNumber(order);
        return purchaseOrder.getItems().stream()
                .map(element -> modelMapper.map(element.getProduct(), ProductDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public PurchaseOrderCreationResponseDTO addPurchaseOrder(PurchaseOrderRequest purchaseOrderRequest) {
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderRequest.getPurchaseOrderDTO();
        List<ItemDTO> itemsDTO = purchaseOrderDTO.getItems();
        String productsIdNotStock = "";

        List<Long> products = itemsDTO.stream()
                .map(element -> element.getProductId()).collect(Collectors.toList());

        for(ItemDTO item:itemsDTO) {
            if(item.getQuantity() > batchRepository.findStockCurrentQuantityByProductId(item.getProductId())) {
                String conc = "\n- " + item.getProductId();
                productsIdNotStock += conc;
            }
        }

        if (productsIdNotStock.length() > 0)
            throw new InsuficientStockException("Stock insuficiente de los productos de id: " + productsIdNotStock);

        itemsDTO.stream()
                    .forEach(element -> {
                        System.out.println(element.getProductId());
                        Integer quantity = element.getQuantity();
                        List<Batch> batches = batchRepository.findAllBatchesByProductId(element.getProductId());
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

        PurchaseOrder purchaseOrder = mapper.fromDTO(purchaseOrderDTO);
        purchaseOrderRepository.saveAndFlush(purchaseOrder);

        return new PurchaseOrderCreationResponseDTO(purchaseOrder.totalPrice());
    }
}
