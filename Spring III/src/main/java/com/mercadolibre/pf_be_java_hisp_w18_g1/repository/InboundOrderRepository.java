package com.mercadolibre.pf_be_java_hisp_w18_g1.repository;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.InboundOrder;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InboundOrderRepository extends JpaRepository<InboundOrder, Long> {
    Optional<InboundOrder> findByOrderNumber(Long orderNumber);
    List<InboundOrder> findAll();
}
