package com.example.frescos.repository;

import com.example.frescos.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {

    @Query(value = "SELECT Sum(b.currentQuantity) FROM Batch b WHERE b.product.id=?1")
    Integer findStockCurrentQuantityByProductId(Long productId);

    @Query(value = "SELECT b from Batch b where b.product.id =?1")
    List<Batch> findAllBatchesByProductId(Long productId);

}
