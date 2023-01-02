package com.mercadolibre.pf_be_java_hisp_w18_g1.service.db;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Section;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Warehouse;
import com.mercadolibre.pf_be_java_hisp_w18_g1.enums.SectionCode;
import com.mercadolibre.pf_be_java_hisp_w18_g1.exceptions.EntityNotFoundException;
import com.mercadolibre.pf_be_java_hisp_w18_g1.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WarehouseDbServiceImpl implements WarehouseDbService{
    @Autowired
    private WarehouseRepository warehouseRepository;
    @Autowired
    private SectionDbService sectionDbService;
    @Override
    public Warehouse findByWarehouseCode(Long wareHouseCode) {
        return warehouseRepository.findByWareHouseCode(wareHouseCode)
                .orElseThrow(()->{throw new EntityNotFoundException("El warehouse " + wareHouseCode + "no existe.");
                });
    }

    @Override
    public List<Warehouse> findAllWarehouseBySectionsAndAgent(SectionCode sectionCode, String userName) {
        List<Section> sections = sectionDbService.findAllBySectionCode(sectionCode);
        List<Warehouse> warehouses = sections.stream()
                .map(s -> warehouseRepository.findWarehouseBySectionsAndAgent_UserName(s, userName))
                .collect(Collectors.toList());

        if (warehouses.isEmpty())
            throw new EntityNotFoundException("El representante " + userName + " no tiene acceso a un warehouse con esas especificaciones.");
        return warehouses;
    }

    @Override
    public Warehouse findWarehouseByWareHouseCodeAndAgent_UserName(Long warehouseCode, String userName) {
        Warehouse warehouse = warehouseRepository.findWarehouseByWareHouseCodeAndAgent_UserName(warehouseCode, userName);
        if (warehouse == null)
            throw new EntityNotFoundException("El representante " + userName + " no tiene acceso a un warehouse con esas especificaciones.");
        return warehouse;
    }

}
