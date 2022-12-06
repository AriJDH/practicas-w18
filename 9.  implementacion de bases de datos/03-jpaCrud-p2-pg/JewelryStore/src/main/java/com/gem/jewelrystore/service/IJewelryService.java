package com.gem.jewelrystore.service;

import com.gem.jewelrystore.dto.request.JewelryRequest;
import com.gem.jewelrystore.dto.response.JewelryCreatedResponse;
import com.gem.jewelrystore.entity.Jewelry;

import java.util.List;

public interface IJewelryService {
    JewelryCreatedResponse createJewelry(JewelryRequest jewelryRequest);
    List<Jewelry> getAllJewelry();
    Jewelry findJewelry(long id);
    void deleteJewelry(long id);
}
