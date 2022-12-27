package com.example.frescos.service;

import com.example.frescos.dtos.request.InboundOrderRequest;
import com.example.frescos.dtos.response.BatchStockResponseDTO;
import com.example.frescos.dtos.InboundOrderDTO;
import com.example.frescos.entity.Agent;
import com.example.frescos.entity.InboundOrder;
import com.example.frescos.entity.Section;
import com.example.frescos.entity.Warehouse;
import com.example.frescos.exception.BadRequestException;
import com.example.frescos.exception.FullSectionException;
import com.example.frescos.exception.IncorrectSectionException;
import com.example.frescos.repository.AgentRepository;
import com.example.frescos.repository.BatchRepository;
import com.example.frescos.security.AuthorizationManager;
import com.example.frescos.service.db.InboundOrderDbService;
import com.example.frescos.service.db.SectionDbService;
import com.example.frescos.service.db.WarehouseDbService;
import com.example.frescos.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class InboundOrderServiceImp implements InboundOrderService {
    @Autowired
    private InboundOrderDbService inboundOrderDbService;
    @Autowired
    private SectionDbService sectionDbService;
    @Autowired
    private BatchRepository batchRepository;
    @Autowired
    private Mapper mapper;
    @Autowired
    private WarehouseDbService warehouseDbService;
    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private AuthorizationManager authorizationManager;

    @Override
    public BatchStockResponseDTO addInboundOrder(Authentication authentication, InboundOrderRequest inboundOrderRequest) {
        InboundOrderDTO inboundOrderDTO = inboundOrderRequest.getInboundOrder();
        authorizationManager.checkWarehouseAuthorization(inboundOrderDTO.getSection().getWarehouseCode(), authentication);
        InboundOrder inboundOrder = mapper.fromDTO(inboundOrderDTO);
        Section section = inboundOrder.getSection();
        checkProductsAreFromSection(inboundOrder, section);
        checkSectionAvailability(inboundOrder, section, 0);
        Agent agent = agentRepository.findByUserName(authentication.getName()).get();
        inboundOrder.setAgent(agent);
        inboundOrderDbService.save(inboundOrder);
        inboundOrder.getBatches().forEach(b->section.addBatch(b));
        sectionDbService.save(section);
        return new BatchStockResponseDTO(inboundOrderDTO.getBatches());
    }

    @Override
    public BatchStockResponseDTO updateInboundOrder(Authentication authentication, InboundOrderRequest inboundOrderRequest) {
        InboundOrderDTO inboundOrderDTO = inboundOrderRequest.getInboundOrder();
        authorizationManager.checkWarehouseAuthorization(inboundOrderDTO.getSection().getWarehouseCode(), authentication);
        InboundOrder existingInboundOrder = inboundOrderDbService.findByOrderNumber(inboundOrderDTO.getOrderNumber());
        InboundOrder newInboundOrder = mapper.fromDTO(inboundOrderDTO);
        if(!existingInboundOrder.getBatches().equals(newInboundOrder.getBatches())){
            Section section = existingInboundOrder.getSection();
            checkProductsAreFromSection(newInboundOrder, section);
            checkSectionAvailability(newInboundOrder, section, -existingInboundOrder.getBatches().size());
            existingInboundOrder.getBatches().forEach(batch->{
                section.removeBatchByBatchNumber(batch.getBatchNumber());
                batchRepository.delete(batch);
            });
        }

        return this.addInboundOrder(authentication, inboundOrderRequest);
    }

    public void checkProductsAreFromSection(InboundOrder inboundOrder, Section section){
        if(inboundOrder.getBatches().stream().anyMatch(batch->!batch.getProduct().getSectionCode().equals(section.getSectionCode())))
            throw new IncorrectSectionException("La orden contiene productos que no corresponden a la sección designada. Corrija la orden e intente otra vez.");
    }

    public void checkSectionAvailability(InboundOrder inboundOrder, Section section, int delta){
        if(!section.containsSpace(inboundOrder.getBatches().size() + delta))
            throw new FullSectionException("No hay suficiente espacio en la sección para almacenar la cantidad de lotes solicitados");
    }


}
