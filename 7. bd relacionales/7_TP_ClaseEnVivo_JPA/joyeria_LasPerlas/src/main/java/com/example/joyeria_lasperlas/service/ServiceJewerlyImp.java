package com.example.joyeria_lasperlas.service;

import com.example.joyeria_lasperlas.dto.request.JewelDTORequest;
import com.example.joyeria_lasperlas.dto.response.JewelDTOResponse;
import com.example.joyeria_lasperlas.entity.Jewel;
import com.example.joyeria_lasperlas.exception.NotFoundException;
import com.example.joyeria_lasperlas.repository.IRepositoryJewerly;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ServiceJewerlyImp implements IServiceJewerly{

    private final IRepositoryJewerly repositoryJewerly;

    private static final ObjectMapper op = new ObjectMapper();

    public ServiceJewerlyImp(IRepositoryJewerly repositoryJewerly){
        this.repositoryJewerly = repositoryJewerly;
        op.registerModule(new JavaTimeModule());
        op.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    @Override
    public List<JewelDTOResponse> getJewerly() {
        return repositoryJewerly
                .findAll()
                .stream()
                .filter(Jewel::getVentaONo)
                .map(x-> op.convertValue(x, JewelDTOResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public Long saveJewel(JewelDTORequest jewelDTORequest) {
        Jewel jewel =  repositoryJewerly.save(op.convertValue(jewelDTORequest, Jewel.class));
        return jewel.getNro_identificatorio();
    }

    @Override
    public void logicDelete(Long id) {
        Jewel jewel = repositoryJewerly.findById(id).orElse(null);
        if (jewel == null) throw new NotFoundException("La joya con id " + id + " no existe.");
        jewel.setVentaONo(false);
        repositoryJewerly.save(jewel);
    }

    @Override
    public JewelDTOResponse updateJewel(JewelDTORequest jewelDTORequest, Long id) {
        Jewel jewel = repositoryJewerly.findById(id).orElse(null);
        if (jewel == null) throw new NotFoundException("La joya con id " + id + " no existe.");
        jewel = op.convertValue(jewelDTORequest, Jewel.class);
        jewel.setNro_identificatorio(id);
        repositoryJewerly.save(jewel);
        return op.convertValue(jewel, JewelDTOResponse.class);
    }
}
