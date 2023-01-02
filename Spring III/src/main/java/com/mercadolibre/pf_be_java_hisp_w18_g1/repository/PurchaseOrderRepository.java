package com.mercadolibre.pf_be_java_hisp_w18_g1.repository;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {
    Optional<PurchaseOrder> findByOrderNumber(Long order);
    List<PurchaseOrder> findAll();
}
