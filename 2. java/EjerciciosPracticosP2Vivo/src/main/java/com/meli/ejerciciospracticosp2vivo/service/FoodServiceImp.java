package com.meli.ejerciciospracticosp2vivo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.meli.ejerciciospracticosp2vivo.dto.FoodDTO;
import com.meli.ejerciciospracticosp2vivo.repository.IFoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FoodServiceImp implements IFoodService{

    @Autowired
    private IFoodRepository foodRepository;

    @Override
    public List<FoodDTO> getFoodAll() {
        ObjectMapper op = new ObjectMapper();
        return foodRepository.getFoodAll().stream().
                map(food -> op.convertValue(food, FoodDTO.class)).
                collect(Collectors.toList());
    }
}
