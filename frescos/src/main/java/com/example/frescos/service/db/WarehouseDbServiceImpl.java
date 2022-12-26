package com.example.frescos.service.db;

import com.example.frescos.entity.Warehouse;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WarehouseDbServiceImpl implements WarehouseDbService{
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Override
    public Warehouse findByWarehouseCode(Long wareHouseCode) {
        return warehouseRepository.findByWareHouseCode(wareHouseCode)
                .orElseThrow(()->{throw new EntityNotFoundException("El warehouse " + wareHouseCode + "no existe.");
        });
    }
}
