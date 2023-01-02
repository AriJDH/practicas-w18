package com.mercadolibre.pf_be_java_hisp_w18_g1.service;

import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.ProductWarehouseDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.SectionBatchesDTO;
import com.mercadolibre.pf_be_java_hisp_w18_g1.dtos.WarehouseDTO;
import org.springframework.security.core.Authentication;

import java.util.List;

public interface WarehouseService {
    List<WarehouseDTO> findByProductForSection(Authentication authentication, Long id, Character order);

    ProductWarehouseDTO findByProduct(Authentication authentication, Long id);

    List<SectionBatchesDTO> findAllProductForSectionInWarehouse(Authentication authentication, Long warehouseCode, Integer minimumStock);
}
