package com.example.frescos.repository;

import com.example.frescos.entity.Batch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BatchRepository extends JpaRepository<Batch, Long> {
    @Query(value = "SELECT * FROM Batch b WHERE b.product.id=:productId")
    List<Batch> findAllBatchesByProductId(@Param("productId") Long productId);

}
