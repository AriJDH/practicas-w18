package com.example.frescos.service.db;

import com.example.frescos.entity.Warehouse;
import com.example.frescos.enums.SectionCode;

import java.util.List;

public interface WarehouseDbService {
    Warehouse findByWarehouseCode(Long wareHouseCode);
    List<Warehouse> findAllBySection(SectionCode sectionCode);
}
