package com.example.frescos.repository;

import com.example.frescos.entity.Product;
import com.example.frescos.entity.PurchaseOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PurchaseOrderRepository extends JpaRepository<PurchaseOrder, Long> {

    Optional<PurchaseOrder> findByOrderNumber(Long order);
    @Query(value = "SELECT p from PurchaseOrder p where p.buyer.id =?1")
    public List<PurchaseOrder> findAllByBuyerId(Long buyerId);
    @Query(value = "SELECT p from PurchaseOrder p where p.buyer.userName =?1")
    public List<PurchaseOrder> findAllByBuyerUserName(String userName);
}
