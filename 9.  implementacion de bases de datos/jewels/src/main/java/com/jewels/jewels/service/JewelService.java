package com.jewels.jewels.service;

import com.jewels.jewels.dto.Request.RequestJewelDTO;
import com.jewels.jewels.dto.Response.JewelResponseDTO;
import com.jewels.jewels.dto.Response.JewelsResponseDTO;
import com.jewels.jewels.dto.Response.ResponseDTO;
import com.jewels.jewels.model.Jewel;
import com.jewels.jewels.repository.IJewelRepository;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JewelService implements IJewelService {

    private IJewelRepository iJewelRepository;

    public JewelService(IJewelRepository iJewelRepository) {
        this.iJewelRepository = iJewelRepository;
    }

    @Override
    public ResponseDTO create(RequestJewelDTO request) {
        Jewel j = new Jewel();

        j.setCode(request.getCode());
        j.setName(request.getName());
        j.setMaterial(request.getMaterial());
        j.setWeight(request.getWeight());
        j.setParticularity(request.getParticularity());
        j.setHasStone(request.getHasStone());
        j.setOnSale(request.getOnSale());

        iJewelRepository.save(j);

        return new ResponseDTO("Jewel was saved with id: " + j.getId(), 201);
    }

    @Override
    public JewelsResponseDTO getList() {
        List<Jewel> list = iJewelRepository.findAll();
        return new JewelsResponseDTO("List of jewels", list);
    }

    @Override
    public ResponseDTO delete(Integer idJewel) {
        iJewelRepository.deleteById(Long.valueOf(idJewel));
        return new ResponseDTO("Jewel was deleted with id: " + idJewel, 200);
    }

    @Override
    public ResponseDTO update(Integer idJewel,RequestJewelDTO request ) {
        Jewel jewel = iJewelRepository.findById(Long.valueOf(idJewel)).orElse(null);

        jewel.setCode(request.getCode());
        jewel.setName(request.getName());
        jewel.setMaterial(request.getMaterial());
        jewel.setWeight(request.getWeight());
        jewel.setParticularity(request.getParticularity());
        jewel.setHasStone(request.getHasStone());
        jewel.setOnSale(request.getOnSale());

        iJewelRepository.save(jewel);

        return new ResponseDTO("Jewel was updated with id: " + idJewel, 200);
    }
}
