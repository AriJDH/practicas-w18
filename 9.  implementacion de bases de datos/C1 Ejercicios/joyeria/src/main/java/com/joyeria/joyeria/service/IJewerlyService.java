package com.joyeria.joyeria.service;

import com.joyeria.joyeria.exception.JewerlyException;
import com.joyeria.joyeria.model.Jewerly;

import java.util.List;

public interface IJewerlyService {

    List<Jewerly> getAll();
    List<Jewerly> getAllJewerliesOnSale();
    Jewerly save (Jewerly jewerly);
    Jewerly findById(Long id);
    Jewerly update (Long id, Jewerly jewerly);
    void deleteLogicallyById(Long id) throws JewerlyException;

}
