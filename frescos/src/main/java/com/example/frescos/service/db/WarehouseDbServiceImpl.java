package com.example.frescos.service.db;

import com.example.frescos.entity.Section;
import com.example.frescos.entity.Warehouse;
import com.example.frescos.enums.SectionCode;
import com.example.frescos.exception.EntityNotFoundException;
import com.example.frescos.repository.WarehouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Warehouse> findAllBySection(SectionCode sectionCode) {
        Section section = sectionDbService.findBySectionCode(sectionCode);
        return warehouseRepository.findAllBySectionsIs(section);
    }

}
