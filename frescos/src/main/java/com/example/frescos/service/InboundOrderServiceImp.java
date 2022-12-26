package com.example.frescos.service;

import com.example.frescos.dtos.InboundOrderDTO;
import com.example.frescos.dtos.ResponseCreateDTO;
import com.example.frescos.entity.InboundOrder;
import com.example.frescos.entity.Section;
import com.example.frescos.service.db.InboundOrderDbService;
import com.example.frescos.service.db.SectionDbService;
import com.example.frescos.utils.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class InboundOrderServiceImp implements InboundOrderService {
    @Autowired
    private InboundOrderDbService inboundOrderDbService;
    @Autowired
    private SectionDbService sectionDbService;
    @Autowired
    private Mapper mapper;

    @Override
    public InboundOrder addInboundOrder(InboundOrderDTO inboundOrderDTO) {
        InboundOrder inboundOrder = inboundOrderDbService.save(mapper.fromDTO(inboundOrderDTO));
        Section section = inboundOrder.getSection();
        inboundOrder.getBatches().forEach(b->section.addBatch(b));
        sectionDbService.save(section);
        return inboundOrder;
    }
}
