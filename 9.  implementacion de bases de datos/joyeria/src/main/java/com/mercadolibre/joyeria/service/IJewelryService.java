package com.mercadolibre.joyeria.service;

import com.mercadolibre.joyeria.dto.CreatedDTO;
import com.mercadolibre.joyeria.dto.request.JewelryDTOReq;

public interface IJewelryService {
    public CreatedDTO createJewelry(JewelryDTOReq jewelryDTOReq);

}
