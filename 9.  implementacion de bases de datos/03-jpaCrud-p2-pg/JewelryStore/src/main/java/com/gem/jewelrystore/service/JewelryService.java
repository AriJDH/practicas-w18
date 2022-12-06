package com.gem.jewelrystore.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.gem.jewelrystore.dto.request.JewelryRequest;
import com.gem.jewelrystore.dto.response.JewelryCreatedResponse;
import com.gem.jewelrystore.entity.Jewelry;
import com.gem.jewelrystore.repository.IJewelryRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryService implements IJewelryService {

    private final ModelMapper modelMapper;
    private final IJewelryRepository jewelryRepository;


    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
        modelMapper = new ModelMapper();
    }

    @Override
    public JewelryCreatedResponse createJewelry(JewelryRequest jewelryRequest) {
        Jewelry jewelry = modelMapper.map(jewelryRequest, Jewelry.class);
        Jewelry savedJewelry = jewelryRepository.save(jewelry);
        return new JewelryCreatedResponse(savedJewelry.getId(), "created, y'all");
    }

    @Override
    public List<Jewelry> getAllJewelry() {
        return jewelryRepository.findAll();
    }

    @Override
    public Jewelry findJewelry(long id) {
        return jewelryRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteJewelry(long id) {
        jewelryRepository.deleteById(id);
    }
}