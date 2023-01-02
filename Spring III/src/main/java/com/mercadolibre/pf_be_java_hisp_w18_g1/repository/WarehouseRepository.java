package com.mercadolibre.pf_be_java_hisp_w18_g1.repository;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Section;
import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Warehouse;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
    Optional<Warehouse> findByWareHouseCode(Long warehouseCode);
    Warehouse findWarehouseBySectionsAndAgent_UserName(Section section, String userName);

    Warehouse findWarehouseByWareHouseCodeAndAgent_UserName(Long warehouseCode, String userName);
    List<Warehouse> findAll();
}
