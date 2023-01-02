package com.example.frescos.service.db;

import com.example.frescos.entity.Buyer;

public interface BuyerDbService {
    Buyer findById(Long id);
}
