package meli.bootcamp.joyerialasperlas.service;

import meli.bootcamp.joyerialasperlas.dto.req.JewelryDtoReq;
import meli.bootcamp.joyerialasperlas.dto.res.JewelrySavedDto;
import meli.bootcamp.joyerialasperlas.entity.Jewelry;

import java.util.List;

public interface IJewelryService {
    JewelrySavedDto saveJewelry(JewelryDtoReq jewelry);
    List<Jewelry> getJewelry();
    void deleteJewelry(Long id);
    JewelrySavedDto updateJewelry(Long id, JewelryDtoReq jewelry);

}
