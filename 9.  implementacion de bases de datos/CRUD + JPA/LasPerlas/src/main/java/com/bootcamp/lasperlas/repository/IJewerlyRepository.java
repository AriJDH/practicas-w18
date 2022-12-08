package com.bootcamp.lasperlas.repository;

import com.bootcamp.lasperlas.entity.Jewerly;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IJewerlyRepository extends JpaRepository<Jewerly, Long> {
}
