package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Buyer;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.EntityNotFoundException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.BuyerRepository;
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
