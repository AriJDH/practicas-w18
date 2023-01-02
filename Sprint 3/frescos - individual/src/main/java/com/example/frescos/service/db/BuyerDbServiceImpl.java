package com.example.frescos.service.db;

import com.example.frescos.entity.Buyer;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerDbServiceImpl implements BuyerDbService{
    @Autowired
    private BuyerRepository buyerRepository;
    @Override
    public Buyer findById(Long id) {
        return buyerRepository.findById(id)
                .orElseThrow(()->{throw new EntityNotFoundException("El comprador "+ id+" no existe.");});
    }
}
