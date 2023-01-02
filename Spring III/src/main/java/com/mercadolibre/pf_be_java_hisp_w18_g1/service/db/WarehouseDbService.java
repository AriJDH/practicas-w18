package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Warehouse;
import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;

import java.util.List;

public interface WarehouseDbService {
    Warehouse findByWarehouseCode(Long wareHouseCode);
    List<Warehouse> findAllWarehouseBySectionsAndAgent(SectionCode sectionCode, String userName);

    Warehouse findWarehouseByWareHouseCodeAndAgent_UserName (Long warehouseCode, String userName);
}
