package com.example.frescos.service.db;

import com.example.frescos.entity.Warehouse;
import com.example.frescos.enums.SectionCode;

import java.util.List;
import java.util.Optional;

public interface WarehouseDbService {
    Warehouse findByWarehouseCode(Long wareHouseCode);
    Warehouse findWarehouseBySectionsAndAgent(SectionCode sectionCode, String name);
}
