package com.example.frescos.service.db;

import com.example.frescos.entity.Warehouse;

public interface WarehouseDbService {
    Warehouse findByWarehouseCode(Long wareHouseCode);
}
