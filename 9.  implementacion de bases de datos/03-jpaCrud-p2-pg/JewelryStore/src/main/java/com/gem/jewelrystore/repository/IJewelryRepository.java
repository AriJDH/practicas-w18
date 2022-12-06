package com.gem.jewelrystore.repository;

import com.gem.jewelrystore.entity.Jewelry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewelryRepository extends JpaRepository<Jewelry, Long> {
}
