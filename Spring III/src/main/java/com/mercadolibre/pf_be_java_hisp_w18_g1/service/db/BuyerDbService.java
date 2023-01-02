package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;


import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Buyer;

public interface BuyerDbService {
    Buyer findById(Long id);
}
