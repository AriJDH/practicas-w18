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
import com.example.frescos.repository.ItemRepository;
import com.example.frescos.repository.PurchaseOrderRepository;
import com.example.frescos.service.db.PurchaseOrderDbService;
import com.example.frescos.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PurchaseOrderServiceImp implements PurchaseOrderService{

    @Autowired
    private PurchaseOrderDbService purchaseOrderDbService;

    @Autowired
    private PurchaseOrderRepository purchaseOrderRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private ItemRepository itemRepository;
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

        this.checkStock(itemsDTO, purchaseOrderDTO.getOrderDate());

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

    @Override
    public PurchaseOrderCreationResponseDTO updatePurchaseOrder(Long orderId, PurchaseOrderRequest purchaseOrderRequest) {
        PurchaseOrderDTO purchaseOrderDTO = purchaseOrderRequest.getPurchaseOrderDTO();
        PurchaseOrder existingPurchaseOrder = purchaseOrderDbService.findByOrderNumber(orderId);
        PurchaseOrder newPurchaseOrder = mapper.fromDTO(purchaseOrderDTO);

        if(!existingPurchaseOrder.getItems().equals(newPurchaseOrder.getItems())){
            existingPurchaseOrder.getItems().forEach(item->{
                int stockToRestore = item.getQuantity();
                List<Batch> batches = batchRepository.findAllBatchesByProductId(item.getId());

                for(Batch batch:batches){
                    if(batch.getCurrentQuantity()<batch.getInitialQuantity() && stockToRestore>0){
                        int stockDiff = batch.getInitialQuantity()-batch.getCurrentQuantity();
                        if(stockDiff>stockToRestore){
                            stockToRestore=0;
                            batch.setCurrentQuantity(batch.getCurrentQuantity()+stockToRestore);
                        }else{
                            stockToRestore-=stockDiff;
                            batch.setCurrentQuantity(batch.getInitialQuantity());
                        }
                    }
                }
                existingPurchaseOrder.removeItem(item);
                itemRepository.delete(item);
            });
        }

        purchaseOrderDbService.delete(existingPurchaseOrder);
        return this.addPurchaseOrder(purchaseOrderRequest);
    }

    public void addItemsToBatches(List<ItemDTO> itemsDTO, PurchaseOrderDTO purchaseOrderDTO){
        this.checkStock(itemsDTO, purchaseOrderDTO.getOrderDate());

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
    }

    public void checkStock(List<ItemDTO> itemsDTO, LocalDate orderDate){
        String productsIdNotStock = "";
        for(ItemDTO item:itemsDTO) {
            int currentStock = batchRepository.findAllBatchesByProductId(item.getProductId())
                    .stream()
                    .filter(batch -> batch.isDueDateOk(orderDate))
                    .mapToInt(batch->batch.getCurrentQuantity())
                    .sum();
            if(item.getQuantity() >currentStock ) {
                String conc = "\n- " + item.getProductId();
                productsIdNotStock += conc;
            }
        }
        if (productsIdNotStock.length() > 0)
            throw new InsuficientStockException("Stock insuficiente de los productos de id (por falta de existencias o existencias con tiempo de vencimiento menor a 3 semanas): " + productsIdNotStock);
    }
}
