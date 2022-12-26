package com.example.frescos.service;

import com.example.frescos.dtos.InboundOrderDTO;
import com.example.frescos.dtos.ResponseCreateDTO;
import com.example.frescos.entity.InboundOrder;
import com.example.frescos.entity.Product;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class InboundOrderServiceImp implements IInboundOrderService{

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public ResponseCreateDTO addInboundOrder(InboundOrderDTO inboundOrderDTO) {
        InboundOrder inboundOrder = modelMapper.map(inboundOrderDTO, InboundOrder.class);
        inboundOrder.getBatches().stream()
                .forEach(element -> element.setProduct());

        return null;
    }
}
