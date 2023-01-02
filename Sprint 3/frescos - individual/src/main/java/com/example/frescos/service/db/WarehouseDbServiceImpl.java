package com.example.frescos.service.db;

import com.example.frescos.entity.Section;
import com.example.frescos.entity.Warehouse;
import com.example.frescos.enums.SectionCode;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.WarehouseRepository;
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
    public List<Warehouse> findAllWarehouseBySectionsAndAgent(SectionCode sectionCode, String name) {
        List<Section> sections = sectionDbService.findAllBySectionCode(sectionCode);
        List<Warehouse> warehouses = sections.stream()
                .map(s -> warehouseRepository.findWarehouseBySectionsAndAgent_UserName(s, name))
                .collect(Collectors.toList());

        if (warehouses.isEmpty())
            throw new EntityNotFoundException("El representante " + name + " no tiene acceso a un warehouse con esas especificaciones.");
        return warehouses;
    }

}
