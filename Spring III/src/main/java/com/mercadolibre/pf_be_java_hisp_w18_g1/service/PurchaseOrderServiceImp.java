package com.mercadolibre.pf_be_java_hisp_w18_g1.service;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ItemDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ProductDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.PurchaseOrderDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.request.PurchaseOrderRequest;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.response.PurchaseOrderCreationResponseDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Batch;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.PurchaseOrder;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.InsuficientStockException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.BatchRepository;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.ItemRepository;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.PurchaseOrderRepository;
import com.mercadolibre.pf_be_java_hisp_w18_g1.service.db.PurchaseOrderDbService;
import com.mercadolibre.pf_be_java_hisp_w18_g1.util.Mapper;
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

        this.updateBatchesStock(purchaseOrderDTO);

        PurchaseOrder purchaseOrder = mapper.fromDTO(purchaseOrderDTO);

        PurchaseOrder savePurchaseOrder = purchaseOrderRepository.saveAndFlush(purchaseOrder);

        return new PurchaseOrderCreationResponseDTO(savePurchaseOrder.getOrderNumber(), purchaseOrder.totalPrice());
    }

    @Override
    public PurchaseOrderCreationResponseDTO updatePurchaseOrder(Long orderId, PurchaseOrderRequest purchaseOrderRequest) {
        PurchaseOrderDTO newPurchaseOrderDTO = purchaseOrderRequest.getPurchaseOrderDTO();
        PurchaseOrder existingPurchaseOrder = purchaseOrderDbService.findByOrderNumber(orderId);
        PurchaseOrder newPurchaseOrder = mapper.fromDTO(newPurchaseOrderDTO);

        if(!existingPurchaseOrder.getItems().equals(newPurchaseOrder.getItems())){
            existingPurchaseOrder.getItems().forEach(item->{
                int stockToRestore = item.getQuantity();
                System.out.println("Stock to restore");
                System.out.println(stockToRestore);
                List<Batch> batches = batchRepository.findAllBatchesByProductId(item.getProduct().getId());
                System.out.println("size batches " + batches.size());
                for(Batch batch:batches){
                    System.out.println("Entre");
                    System.out.println("current" + batch.getCurrentQuantity());
                    System.out.println("initial"+batch.getInitialQuantity());
                    if(batch.getCurrentQuantity()<batch.getInitialQuantity() && stockToRestore>0){
                        System.out.println("Entre if 1");
                        int stockDiff = batch.getInitialQuantity()-batch.getCurrentQuantity();
                        System.out.println("Stock diff");
                        System.out.println(stockDiff);
                        if(stockDiff>stockToRestore){
                            System.out.println("Entre if 2");
                            stockToRestore=0;
                            batch.setCurrentQuantity(batch.getCurrentQuantity()+stockToRestore);
                        }else{
                            System.out.println("Entre else 2");
                            stockToRestore-=stockDiff;
                            batch.setCurrentQuantity(batch.getInitialQuantity());
                        }
                        batchRepository.save(batch);
                    }
                }
                //existingPurchaseOrder.removeItem(item);
                //itemRepository.delete(item);
            });
        }

        this.updateBatchesStock(newPurchaseOrderDTO);
        existingPurchaseOrder.setOrderDate(newPurchaseOrder.getOrderDate());
        existingPurchaseOrder.setBuyer(newPurchaseOrder.getBuyer());
        existingPurchaseOrder.setStatus(newPurchaseOrder.getStatus());
        existingPurchaseOrder.removeAllItems();
        existingPurchaseOrder.addAllItems(newPurchaseOrder.getItems());

        PurchaseOrder savedPurchaseOrder = purchaseOrderDbService.save(existingPurchaseOrder);
        return new PurchaseOrderCreationResponseDTO(savedPurchaseOrder.getOrderNumber(), existingPurchaseOrder.totalPrice());
    }

    public void updateBatchesStock(PurchaseOrderDTO purchaseOrderDTO){
        List<ItemDTO > itemsDTO = purchaseOrderDTO.getItems();
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
