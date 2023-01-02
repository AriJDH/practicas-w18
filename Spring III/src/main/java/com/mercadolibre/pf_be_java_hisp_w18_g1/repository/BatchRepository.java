package com.mercadolibre.pf_be_java_hisp_w18_g1.repository;

import com.mercadolibre.pf_be_java_hisp_w18_g1.entity.Batch;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    @Query(value = "SELECT Sum(b.currentQuantity) FROM Batch b WHERE b.product.id=?1")
    Integer findStockCurrentQuantityByProductId(Long productId);
    @Query(value = "SELECT b from Batch b where b.product.id =?1")
    List<Batch> findAllBatchesByProductId(Long productId);
    List<Batch> findAll();
    Optional<Batch> findByBatchNumber(Long aLong);
}
