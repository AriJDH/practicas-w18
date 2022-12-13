package com.mercadolibre.joyeria.service;

import com.mercadolibre.joyeria.dto.CreatedDTO;
import com.mercadolibre.joyeria.dto.request.JewelryDTOReq;
import com.mercadolibre.joyeria.repository.IJewelryRepository;
import org.springframework.stereotype.Service;

@Service
public class JewelryService implements IJewelryService {

    private final IJewelryRepository jewRepo;

    public JewelryService(IJewelryRepository jewRepo) {
        this.jewRepo = jewRepo;
    }

    @Override
    public CreatedDTO createJewelry(JewelryDTOReq jewelryDTOReq) {
        return jewRepo.save(jewelryDTOReq);
    }
}
