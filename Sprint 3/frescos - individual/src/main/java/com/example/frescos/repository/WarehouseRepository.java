package com.example.frescos.repository;

import com.example.frescos.entity.Section;
import com.example.frescos.entity.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByWareHouseCode(Long warehouseCode);

    Warehouse findWarehouseBySectionsAndAgent_UserName(Section section, String name);

}
